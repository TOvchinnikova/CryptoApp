package com.t_ovchinnikova.cryptoapp.presentation

import android.app.Application
import com.t_ovchinnikova.cryptoapp.di.DaggerApplicationComponent

class CoinApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}