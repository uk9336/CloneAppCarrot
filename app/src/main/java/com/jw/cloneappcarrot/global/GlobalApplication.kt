package com.jw.cloneappcarrot.global

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by LJW on 2021/12/03.
 *
 * Description :
 */
@HiltAndroidApp
class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}