package com.t_ovchinnikova.cryptoapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.t_ovchinnikova.cryptoapp.data.model.CoinPriceInfo

class CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinPriceInfo>() {
    override fun areItemsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinPriceInfo, newItem: CoinPriceInfo): Boolean {
        return oldItem == newItem
    }
}