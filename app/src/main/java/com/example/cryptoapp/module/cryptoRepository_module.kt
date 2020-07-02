package com.example.cryptoapp.module

import com.example.cryptoapp.repository.CryptoRepository
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val repositoryModule = module {
    factory { CryptoRepository(get()) }
}