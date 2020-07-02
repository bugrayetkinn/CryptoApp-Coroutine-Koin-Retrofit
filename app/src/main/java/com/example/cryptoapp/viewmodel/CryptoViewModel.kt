package com.example.cryptoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.api.CryptoModel
import com.example.cryptoapp.repository.CryptoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CryptoViewModel(private val repository: CryptoRepository) : ViewModel() {

    /**
     * LiveData'nı böyle kullanıdıgın zaman dışarıdan(Fragment,Activity vs.) set edilemicek, sadece
     * observe edebilceksin.
     */
    private val _allCrypto = MutableLiveData<List<CryptoModel>>()
    val allCrypto get() = _allCrypto

    init {
        crypto()
    }

    private fun crypto() {
        // Kullancagın dispatcer'ı bu şekilde Main,IO,Default vs. gibi belirleyebilirsin.
        viewModelScope.launch(Dispatchers.IO) {
            _allCrypto.postValue(repository.getAllCrypto())
        }
    }
}