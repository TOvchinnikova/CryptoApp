package com.t_ovchinnikova.cryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.t_ovchinnikova.cryptoapp.data.database.AppDatabase
import com.t_ovchinnikova.cryptoapp.data.mapper.CoinMapper
import com.t_ovchinnikova.cryptoapp.data.network.ApiFactory
import com.t_ovchinnikova.cryptoapp.data.workers.RefreshDataWorker
import com.t_ovchinnikova.cryptoapp.domain.CoinInfo
import com.t_ovchinnikova.cryptoapp.domain.CoinRepository
import kotlinx.coroutines.delay

class CoinRepositoryImpl(private val application: Application) : CoinRepository {

    private val coinInfoDao = AppDatabase.newInstance(application).coinPriceInfoDao()

    private val mapper = CoinMapper()

    override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return Transformations.map(coinInfoDao.getPriceList()) { it ->
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return Transformations.map(coinInfoDao.getPriceInfoAboutCoin(fromSymbol)) {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}