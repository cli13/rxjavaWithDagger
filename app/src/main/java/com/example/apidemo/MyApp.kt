package com.example.apidemo

import android.app.Application
import com.example.apidemo.DI.ApiComponent
import com.example.apidemo.DI.DaggerApiComponent
import com.example.apidemo.ui.MainActivity

class MyApp : Application() {
    private lateinit var _appComponent: ApiComponent
    val appComponent get() = _appComponent

    override fun onCreate() {
        super.onCreate()
        _appComponent = DaggerApiComponent.create()
    }
}