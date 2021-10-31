package com.t_ovchinnikova.cryptoapp.data.network

import com.t_ovchinnikova.cryptoapp.data.network.model.CoinNamesListDto
import com.t_ovchinnikova.cryptoapp.data.network.model.CoinInfoJsonContainerDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top/totalvolfull")
    suspend fun getTopCoinsInfo(
        @Query(QUERY_PARAM_APi_KEY) apiKey: String = "79e9e27fc5d0b115c0d60bb5724699fb1600d853e2d72d93ad3434a263db5ede",
        @Query(QUERY_PARAM_LIMIT) limit: Int = 10,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String = CURRENCY
    ): CoinNamesListDto

    @GET("pricemultifull")
    suspend fun getFullPriceList(
        @Query(QUERY_PARAM_APi_KEY) apiKey: String = "79e9e27fc5d0b115c0d60bb5724699fb1600d853e2d72d93ad3434a263db5ede",
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String = CURRENCY

    ): CoinInfoJsonContainerDto

    companion object {
        private const val QUERY_PARAM_APi_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"

        private const val CURRENCY = "USD"
    }
}