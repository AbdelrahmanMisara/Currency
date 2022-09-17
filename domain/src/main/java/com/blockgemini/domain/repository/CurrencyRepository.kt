package com.blockgemini.domain.repository

import com.blockgemini.domain.models.ConvertModel
import com.blockgemini.domain.models.HistoryModel
import com.blockgemini.domain.models.LatestModel

interface CurrencyRepository {

    suspend fun getLatest(): LatestModel

    suspend fun convert(amount: Int, from: String, to: String): ConvertModel

    suspend fun getHistory(startDate: String, endDate: String, symbols: String): HistoryModel

    suspend fun getOthers(symbols: String): LatestModel
}