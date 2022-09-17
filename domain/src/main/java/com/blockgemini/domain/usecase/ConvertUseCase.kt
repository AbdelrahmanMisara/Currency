package com.blockgemini.domain.usecase

import com.blockgemini.domain.repository.CurrencyRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ConvertUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

    operator fun invoke(amount: Int, from: String, to: String) = flow {

        val result = currencyRepository.convert(amount, from, to)

        emit(result)
    }
}