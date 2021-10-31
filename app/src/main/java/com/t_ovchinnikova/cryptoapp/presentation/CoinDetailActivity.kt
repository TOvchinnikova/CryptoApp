package com.t_ovchinnikova.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.t_ovchinnikova.cryptoapp.databinding.ActivityCoinDetailBinding
import com.t_ovchinnikova.cryptoapp.data.model.CoinPriceInfo

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel
    private lateinit var binding: ActivityCoinDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }
        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL) as String
        setupViewModel(fromSymbol)
    }

    private fun setupViewModel(fromSymbol: String) {
        viewModel = ViewModelProvider(this) [CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(this) {
            initView(it)
        }
    }

    private fun initView(coin: CoinPriceInfo) {
        with(binding) {
            tvFromSymbol.text = coin.fromSymbol
            tvToSymbol.text = coin.toSymbol
            tvPrice.text = coin.price.toString()
            tvMinPrice.text = coin.lowDay.toString()
            tvMaxPrice.text = coin.highDay.toString()
            tvLastMarket.text = coin.lastMarket
            tvLastUpdate.text = coin.getFormattedTime()
            Picasso.get().load(coin.getFullImageUrl()).into(ivLogoCoin)
        }
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        fun newIntent(context: Context, fromSymbol: String): Intent {
            val intent = Intent(context, CoinDetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_SYMBOL, fromSymbol)
            return intent
        }
    }
}