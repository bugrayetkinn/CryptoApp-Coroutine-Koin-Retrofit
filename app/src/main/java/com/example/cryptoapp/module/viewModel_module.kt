package com.example.cryptoapp.module

import com.example.cryptoapp.viewmodel.CryptoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val viewModelModule = module {
    viewModel { CryptoViewModel(get()) }
}
