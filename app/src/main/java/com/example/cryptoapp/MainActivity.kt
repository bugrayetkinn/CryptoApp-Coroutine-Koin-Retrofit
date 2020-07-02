package com.example.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.cryptoapp.api.CryptoModel
import com.example.cryptoapp.databinding.ActivityMainBinding
import com.example.cryptoapp.repository.CryptoRepository
import com.example.cryptoapp.viewmodel.CryptoViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val mainBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val cryptoViewModel: CryptoViewModel by viewModel()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)

        cryptoViewModel.crypto()?.observe(this, Observer { it ->

            it.forEach {
                Log.e(it.currency, it.price)
            }

        })
    }
}