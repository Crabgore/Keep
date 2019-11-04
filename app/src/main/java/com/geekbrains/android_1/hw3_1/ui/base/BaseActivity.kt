package com.geekbrains.android_1.hw3_1.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer

abstract class BaseActivity<T, S : BaseViewState<T>> : AppCompatActivity() {
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
        it.message?.let { message ->
            showError(message)
        }
    }

    abstract fun renderData(data: T)

    private fun showError(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
