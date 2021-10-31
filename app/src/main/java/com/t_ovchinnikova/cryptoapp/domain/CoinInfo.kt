package com.t_ovchinnikova.cryptoapp.domain

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfo(
    val fromSymbol: String,
    val toSymbol: String?,
    val price: Double?,
    val lastUpdate: Long?,
    val highDay: Double?,
    val lowDay: Double?,
    val lastMarket: String?,
    val imageUrl: String?
)
