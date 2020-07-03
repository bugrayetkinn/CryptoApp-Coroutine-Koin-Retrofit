package com.example.cryptoapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.viewmodel.CryptoViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    private val mainBinding by viewBinding(ActivityMainBinding::inflate)

    private val cryptoViewModel: CryptoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        cryptoViewModel.getAllCrypto.observe(this, Observer { cryptoList ->

            cryptoList.forEach {
                Log.e(it.currency, it.price)
            }
        })
    }
}