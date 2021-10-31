package com.t_ovchinnikova.cryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.t_ovchinnikova.cryptoapp.data.repository.CoinRepositoryImpl
import com.t_ovchinnikova.cryptoapp.domain.GetCoinInfoListUseCase
import com.t_ovchinnikova.cryptoapp.domain.GetCoinInfoUseCase
import com.t_ovchinnikova.cryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)


}