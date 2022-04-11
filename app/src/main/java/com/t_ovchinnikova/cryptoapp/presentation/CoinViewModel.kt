package com.t_ovchinnikova.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.t_ovchinnikova.cryptoapp.domain.GetCoinInfoListUseCase
import com.t_ovchinnikova.cryptoapp.domain.GetCoinInfoUseCase
import com.t_ovchinnikova.cryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    getCoinInfoListUseCase: GetCoinInfoListUseCase,
    loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

    val coinInfoList = getCoinInfoListUseCase()

    init {
        loadDataUseCase()
    }

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


}