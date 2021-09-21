package com.t_ovchinnikova.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.t_ovchinnikova.cryptoapp.api.ApiFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this) [CoinViewModel::class.java]
//        viewModel.priceList.observe(this) {
//            Log.d("MyLog", "Success of activity: $it")
//        }

        viewModel.getDetailInfo("BTC").observe(this) {
            Log.d("MyLog", "Success of activity: $it")
        }

    }

}