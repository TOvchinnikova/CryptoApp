package com.t_ovchinnikova.cryptoapp.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import com.t_ovchinnikova.cryptoapp.presentation.CoinInfoDiffCallback
import com.t_ovchinnikova.cryptoapp.presentation.CoinInfoViewHolder
import com.t_ovchinnikova.cryptoapp.R
import com.t_ovchinnikova.cryptoapp.data.model.CoinPriceInfo


class CoinInfoAdapter(private val context: Context) : ListAdapter<CoinPriceInfo, CoinInfoViewHolder>(
    CoinInfoDiffCallback()) {

    var onCoinClickListener: OnCoinClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = getItem(position)
        with(holder) {
            val symbolsTemplate = context.resources.getString(R.string.symbols_template)
            val lastUpdateTemplate = context.resources.getString(R.string.last_update_template)
            tvPrice.text = coin.price.toString()
            tvSymbols.text = String.format(symbolsTemplate, coin.fromSymbol, coin.toSymbol)
            tvLastUpdate.text = String.format(lastUpdateTemplate, coin.getFormattedTime())
            Picasso.get().load(coin.getFullImageUrl()).into(ivLogoCoin)
            itemView.setOnClickListener {
                onCoinClickListener?.onCoinClick(coin)
            }
        }
    }

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}