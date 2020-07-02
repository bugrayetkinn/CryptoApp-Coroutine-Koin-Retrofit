package com.example.cryptoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.api.CryptoModel
import com.example.cryptoapp.repository.CryptoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoViewModel(private val repository: CryptoRepository) : ViewModel() {


    var allCrypto: LiveData<List<CryptoModel>>? = null

    fun crypto(): LiveData<List<CryptoModel>>? {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                allCrypto = repository.getAllCrypto()
            }
        }
        return allCrypto
    }


}