package com.t_ovchinnikova.cryptoapp.di

import com.t_ovchinnikova.cryptoapp.data.workers.ChildWorkerFactory
import com.t_ovchinnikova.cryptoapp.data.workers.RefreshDataWorker
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(RefreshDataWorker::class)
    fun bindRefreshDataWorkerFactory(worker: RefreshDataWorker.Factory): ChildWorkerFactory
}