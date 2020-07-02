package com.example.cryptoapp

import android.app.Application
import com.example.cryptoapp.module.networkModule
import com.example.cryptoapp.module.repositoryModule
import com.example.cryptoapp.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class CryptoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CryptoApp)
            modules(
                networkModule, repositoryModule,
                viewModelModule
            )
        }
    }
}