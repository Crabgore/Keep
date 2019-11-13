package com.geekbrains.android_1.hw3_1

import android.app.Application
import com.geekbrains.android_1.hw3_1.di.appModule
import com.geekbrains.android_1.hw3_1.di.mainModule
import com.geekbrains.android_1.hw3_1.di.noteModule
import com.geekbrains.android_1.hw3_1.di.splashModule
import com.github.ajalt.timberkt.Timber
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(timber.log.Timber.DebugTree())
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}