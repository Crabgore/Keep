package com.geekbrains.android_1.hw3_1.ui.base

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.firebase.ui.auth.AuthUI
import com.geekbrains.android_1.hw3_1.R
import com.geekbrains.android_1.hw3_1.data.errors.NoAuthException

abstract class BaseActivity<T, S : BaseViewState<T>> : AppCompatActivity() {
    companion object {
        private const val RC_SIGN_IN = 42
    }
    abstract val viewModel: BaseViewModel<T, S>
    abstract val layoutRes: Int?


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutRes?.let {
            setContentView(it)
        }
        viewModel.getViewState().observe(this, Observer<S> { it ->
            it ?: return@Observer
            it.error?.let {
                renderError(it)
                return@Observer
            }

            renderData(it.data)
        })
    }

    private fun renderError(error: Throwable?) = error?.let {
        when (error) {
            is NoAuthException -> startLogin()
            else -> it.message?.let { message ->
                showError(message)
            }
        }
    }

    private fun startLogin() {
        val providers = listOf(
                AuthUI.IdpConfig.GoogleBuilder().build()
        )

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setLogo(R.drawable.android_robot)
                        .setTheme(R.style.LoginStyle)
                        .setAvailableProviders(providers)
                        .build()
                , RC_SIGN_IN
        )
    }

    abstract fun renderData(data: T)

    private fun showError(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN && resultCode != Activity.RESULT_OK) {
            finish()
        }
    }
}
