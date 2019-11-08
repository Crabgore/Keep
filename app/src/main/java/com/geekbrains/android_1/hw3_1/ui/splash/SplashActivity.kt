package com.geekbrains.android_1.hw3_1.ui.splash

import androidx.lifecycle.ViewModelProviders
import com.geekbrains.android_1.hw3_1.ui.base.BaseActivity
import com.geekbrains.android_1.hw3_1.ui.main.MainActivity

class SplashActivity: BaseActivity<Boolean?, SplashViewState>() {

    override val viewModel by lazy {
        ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override val layoutRes: Int? = null

    override fun onResume() {
        super.onResume()
        viewModel.requestUser()
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            MainActivity.start(this)
        }
    }
}