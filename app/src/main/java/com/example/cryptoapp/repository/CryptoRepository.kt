package com.example.cryptoapp.repository

import com.example.cryptoapp.api.CryptoAPI
import com.example.cryptoapp.api.CryptoModel


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoRepository(private val api: CryptoAPI) {

    /**
     * Repository katmanında ayrıyetten bi CoroutineContext oluşturmak yerine suspend fun. ile
     * viewModel'a paslayabilirsin, memoryleak'den kurtarır seni çünkü her scope'un bir job'u olur
     * ve işin bittiginde cancel etmen gerekir suspend ile paslarsan viewModelScope kendiliginden
     * cancel oldugu için bir problem cıkarmaz.
     */
    suspend fun getAllCrypto(): List<CryptoModel>? {
        val response = api.getAllCrypto()
        return if (response.isSuccessful) {
            response.body()
        } else {
            emptyList()
        }
    }
}
