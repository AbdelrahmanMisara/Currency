package com.blockgemini.domain.usecase

import android.text.format.DateUtils
import com.blockgemini.domain.repository.CurrencyRepository
import com.blockgemini.domain.utils.Utils
import kotlinx.coroutines.flow.flow
import java.text.DateFormat
import java.util.*
import javax.inject.Inject

class HistoryUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

    operator fun invoke(symbols: String) = flow {
val current = Calendar.getInstance()
        val endDate = Utils.dateFormat(current.timeInMillis)
        current.set(Calendar.DAY_OF_MONTH,current.get(Calendar.DAY_OF_MONTH) - 2)
        val startDate = Utils.dateFormat(current.timeInMillis)
        val result = currencyRepository.getHistory(startDate, endDate, symbols)

        emit(result)
    }
}