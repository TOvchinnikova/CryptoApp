package com.t_ovchinnikova.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import com.t_ovchinnikova.cryptoapp.R
import com.t_ovchinnikova.cryptoapp.databinding.ItemCoinInfoBinding
import com.t_ovchinnikova.cryptoapp.domain.CoinInfo
import com.t_ovchinnikova.cryptoapp.presentation.CoinInfoDiffCallback
import com.t_ovchinnikova.cryptoapp.presentation.CoinInfoViewHolder


class CoinInfoAdapter(private val context: Context) : ListAdapter<CoinInfo, CoinInfoViewHolder>(
    CoinInfoDiffCallback()) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val binding = ItemCoinInfoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoinInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder.binding) {
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
            tvPrice.text = coin.price.toString()
            tvSymbols.text = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
            tvLastUpdate.text = String.format(lastUpdateTemplate, coin.lastUpdate)
            Picasso.get().load(coin.imageUrl).into(ivLogoCoin)
            root.setOnClickListener {
                onCoinClickListener?.onCoinClick(coin)
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinInfo)
    }
}