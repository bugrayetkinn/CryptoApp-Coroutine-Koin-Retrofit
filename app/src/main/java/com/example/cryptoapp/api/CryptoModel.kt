package com.example.cryptoapp.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
data class CryptoModel(
    @SerializedName("currency")
    @Expose
    val currency: String,

    @SerializedName("price")
    @Expose
    val price: String
)