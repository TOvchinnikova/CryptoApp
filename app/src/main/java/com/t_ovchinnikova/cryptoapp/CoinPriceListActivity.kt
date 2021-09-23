package com.t_ovchinnikova.cryptoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.t_ovchinnikova.cryptoapp.adapters.CoinInfoAdapter
import com.t_ovchinnikova.cryptoapp.databinding.ActivityCoinPriceListBinding
import com.t_ovchinnikova.cryptoapp.pojo.CoinPriceInfo


class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinPriceListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = CoinInfoAdapter(this)
        /*adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                TODO("Not yet implemented")
            }
        }*/
        binding.rvCoinPriceList.adapter = adapter
        viewModel = ViewModelProvider(this) [CoinViewModel::class.java]
        viewModel.getDetailInfo("BTC").observe(this) {
            Log.d("MyLog", "Success of activity: $it")
        }
        viewModel.priceList.observe(this) {
            adapter.submitList(it)
        }
    }
}