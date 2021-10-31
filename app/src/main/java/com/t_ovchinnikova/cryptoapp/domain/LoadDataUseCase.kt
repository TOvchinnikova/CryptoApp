package com.t_ovchinnikova.cryptoapp.domain

class LoadDataUseCase(
    private val repository: CoinRepository
) {
   operator fun invoke() = repository.loadData()
}