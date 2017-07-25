package com.example.eleven.kotlinrealmlist

import android.app.Application
import io.realm.Realm

/**
 * Created by ELEVEN on 7/25/2017.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}