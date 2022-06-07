package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val allModules = listOf(
            mapperModule,
            networkModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )
        startKoin {
            androidContext(this@AppApplication)
            modules(
                allModules
            )
        }
    }
}