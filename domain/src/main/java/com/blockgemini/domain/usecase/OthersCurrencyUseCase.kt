package com.blockgemini.domain.usecase

import com.blockgemini.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OthersCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

operator fun invoke() = flow {
    val result = currencyRepository.getOthers("USD,EGP,JPY,CAD,AED,SAR,MAD,ZAR,CNY,AUD")

    emit(result)
}

}