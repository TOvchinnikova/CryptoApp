package com.t_ovchinnikova.cryptoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.t_ovchinnikova.cryptoapp.presentation.adapters.CoinInfoAdapter
import com.t_ovchinnikova.cryptoapp.databinding.ActivityCoinPriceListBinding
import com.t_ovchinnikova.cryptoapp.data.model.CoinPriceInfo


class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinPriceListBinding
    private lateinit var coinInfoAdapter: CoinInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this) {
            coinInfoAdapter.submitList(it)
        }
    }

    private fun setupRecyclerView() {
        coinInfoAdapter = CoinInfoAdapter(this)
        coinInfoAdapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = CoinDetailActivity.newIntent(
                    this@CoinPriceListActivity,
                    coinPriceInfo.fromSymbol
                )
                startActivity(intent)
            }
        }
        binding.rvCoinPriceList.adapter = coinInfoAdapter
    }
}