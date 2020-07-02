package com.example.cryptoapp.viewmodel

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


    private val _allCrypto = MutableLiveData<List<CryptoModel>>()
    val getAllCrypto get() = _allCrypto

    init {
        crypto()
    }

    private fun crypto() {
        viewModelScope.launch(Dispatchers.IO) {

            withContext(Dispatchers.Main) {
                _allCrypto.postValue(repository.getAllCrypto().value)
            }
        }
    }
}