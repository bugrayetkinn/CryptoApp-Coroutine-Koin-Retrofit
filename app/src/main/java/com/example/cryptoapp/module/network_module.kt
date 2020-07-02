package com.example.cryptoapp.module

import com.example.cryptoapp.api.CryptoAPI
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://api.nomics.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory {
        get<Retrofit>().create(CryptoAPI::class.java)
    }
}