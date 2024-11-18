package com.sopt.shinmungo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ShinMunGoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        plantTimber()
    }

    private fun plantTimber() {
        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}