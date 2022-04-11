package com.t_ovchinnikova.cryptoapp.di

import android.app.Application
import com.t_ovchinnikova.cryptoapp.presentation.CoinApp
import com.t_ovchinnikova.cryptoapp.presentation.CoinDetailFragment
import com.t_ovchinnikova.cryptoapp.presentation.CoinPriceListActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: CoinPriceListActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}