package com.example.cryptoapp.api

import retrofit2.Response
import retrofit2.http.GET


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface CryptoAPI {

    @GET("prices?key=77695d0f51032d8c1f9b1c6c8ea23781")
    suspend fun getAllCrypto(): Response<List<CryptoModel>>
}