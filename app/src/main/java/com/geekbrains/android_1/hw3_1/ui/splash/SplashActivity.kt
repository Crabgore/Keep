package com.geekbrains.android_1.hw3_1.ui.splash

import org.koin.android.viewmodel.ext.android.viewModel
import com.geekbrains.android_1.hw3_1.ui.base.BaseActivity
import com.geekbrains.android_1.hw3_1.ui.main.MainActivity

class SplashActivity : BaseActivity<Boolean?>() {
    override val model: SplashViewModel by viewModel()

    override val layoutRes: Int? = null

    override fun onResume() {
        super.onResume()
        model.requestUser()
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            MainActivity.start(this)
        }
    }
}