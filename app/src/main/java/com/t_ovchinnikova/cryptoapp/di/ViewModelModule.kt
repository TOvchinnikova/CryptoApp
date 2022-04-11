package com.t_ovchinnikova.cryptoapp.di

import androidx.lifecycle.ViewModel
import com.t_ovchinnikova.cryptoapp.presentation.CoinViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinViewModel::class)
    fun bindCOinViewModel(viewModel: CoinViewModel): ViewModel
}