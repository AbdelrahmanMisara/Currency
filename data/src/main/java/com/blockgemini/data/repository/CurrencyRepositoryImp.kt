package com.blockgemini.data.repository

import com.blockgemini.data.mappers.toModel
import com.blockgemini.data.remote.CurrencyApiService
import com.blockgemini.domain.models.ConvertModel
import com.blockgemini.domain.models.HistoryModel
import com.blockgemini.domain.models.LatestModel
import com.blockgemini.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImp @Inject constructor(
    private val currencyApiService: CurrencyApiService
): CurrencyRepository {
    override suspend fun getLatest(): LatestModel {
        return currencyApiService.getLatest().toModel()
    }

    override suspend fun convert(amount: Int, from: String, to: String): ConvertModel {
        return currencyApiService.convert(amount, from, to).toModel()
    }

    override suspend fun getHistory(startDate: String, endDate: String, symbols: String): HistoryModel {
        return currencyApiService.getHistory(startDate, endDate, symbols).toModel()
    }

    override suspend fun getOthers(symbols: String): LatestModel {
        return currencyApiService.getLatest(symbols).toModel()
    }
}