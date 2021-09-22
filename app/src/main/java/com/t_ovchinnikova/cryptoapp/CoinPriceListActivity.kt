package com.t_ovchinnikova.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider


class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)

        viewModel = ViewModelProvider(this) [CoinViewModel::class.java]
//        viewModel.priceList.observe(this) {
//            Log.d("MyLog", "Success of activity: $it")
//        }

        viewModel.getDetailInfo("BTC").observe(this) {
            Log.d("MyLog", "Success of activity: $it")
        }

    }

}