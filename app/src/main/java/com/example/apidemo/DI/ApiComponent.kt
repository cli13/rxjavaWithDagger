package com.example.apidemo.DI

import com.example.apidemo.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyApiClient::class])
interface ApiComponent {
    fun injectMainFactory(activity: MainActivity)
}