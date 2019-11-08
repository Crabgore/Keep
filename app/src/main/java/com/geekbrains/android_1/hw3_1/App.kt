package com.geekbrains.android_1.hw3_1

import android.app.Application
import com.github.ajalt.timberkt.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(timber.log.Timber.DebugTree())
    }
}
