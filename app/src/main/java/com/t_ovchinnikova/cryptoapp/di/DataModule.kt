package com.t_ovchinnikova.cryptoapp.di

import android.app.Application
import com.t_ovchinnikova.cryptoapp.data.database.AppDatabase
import com.t_ovchinnikova.cryptoapp.data.database.CoinInfoDao
import com.t_ovchinnikova.cryptoapp.data.repository.CoinRepositoryImpl
import com.t_ovchinnikova.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.newInstance(application).coinPriceInfoDao()
        }
    }
}