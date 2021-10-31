package com.t_ovchinnikova.cryptoapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.t_ovchinnikova.cryptoapp.data.network.model.CoinInfoDto
import com.t_ovchinnikova.cryptoapp.domain.CoinInfo

class CoinInfoDiffCallback : DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}