package com.example.cryptoapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.api.CryptoAPI
import com.example.cryptoapp.api.CryptoModel


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoRepository(private val api: CryptoAPI) {

    private val cryptoList: MutableLiveData<List<CryptoModel>> = MutableLiveData()

    suspend fun getAllCrypto(): MutableLiveData<List<CryptoModel>> {

        val response = api.getAllCrypto()

        if (response.isSuccessful) {
            response.body().let {
                cryptoList.value = it
            }
        }
        return cryptoList
    }

}