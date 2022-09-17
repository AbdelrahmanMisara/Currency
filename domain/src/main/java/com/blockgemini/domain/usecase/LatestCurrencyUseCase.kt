package com.blockgemini.domain.usecase

import com.blockgemini.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LatestCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

operator fun invoke() = flow {
    val result = currencyRepository.getLatest()

    emit(result)
}

}