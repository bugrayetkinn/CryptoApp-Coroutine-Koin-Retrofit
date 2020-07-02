package com.example.cryptoapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.cryptoapp.api.CryptoAPI
import com.example.cryptoapp.api.CryptoModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoRepository(private val api: CryptoAPI) {

    private val cryptoList: MutableLiveData<List<CryptoModel>> = MutableLiveData()

    fun getAllCrypto(): MutableLiveData<List<CryptoModel>> {

        CoroutineScope(Dispatchers.IO).launch {

            val response = api.getAllCrypto()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    response.body().let {
                        cryptoList.value = it
                    }
                }
            }
        }
        return cryptoList
    }

}