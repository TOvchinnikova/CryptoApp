package com.t_ovchinnikova.cryptoapp.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

import android.media.Rating




data class CoinInfo (
    @SerializedName("Name")
    @Expose
    val name: String? = null
)