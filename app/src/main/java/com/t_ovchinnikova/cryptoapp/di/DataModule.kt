package com.t_ovchinnikova.cryptoapp.di

import android.app.Application
import com.t_ovchinnikova.cryptoapp.data.database.AppDatabase
import com.t_ovchinnikova.cryptoapp.data.database.CoinInfoDao
import com.t_ovchinnikova.cryptoapp.data.network.ApiFactory
import com.t_ovchinnikova.cryptoapp.data.network.ApiService
import com.t_ovchinnikova.cryptoapp.data.repository.CoinRepositoryImpl
import com.t_ovchinnikova.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.newInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}