package com.t_ovchinnikova.cryptoapp.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class CoinInfoListOfData (
    @SerializedName("Data")
    @Expose
    private val data: List<Datum>? = null
)