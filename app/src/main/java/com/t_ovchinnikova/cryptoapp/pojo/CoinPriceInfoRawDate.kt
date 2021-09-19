package com.t_ovchinnikova.cryptoapp.pojo

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class CoinPriceInfoRawDate (
    @SerializedName("RAW")
    @Expose
    var coinPriceJsonRawObject: JsonObject? = null
)