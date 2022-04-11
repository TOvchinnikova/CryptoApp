package com.t_ovchinnikova.cryptoapp.di

import android.app.Application
import com.t_ovchinnikova.cryptoapp.presentation.CoinDetailFragment
import com.t_ovchinnikova.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}