package com.blockgemini.data.remote

import com.blockgemini.data.dto.ConvertDto
import com.blockgemini.data.dto.HistoryDto
import com.blockgemini.data.dto.LatestDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {

@GET("latest")
suspend fun getLatest(
    @Query ("symbols") symbols: String? = null
): LatestDto

@GET("convert")
suspend fun convert(
    @Query ("amount") amount: Int,
    @Query ("from") from: String,
    @Query ("to") to: String
): ConvertDto

@GET("timeseries")
suspend fun getHistory(
    @Query ("start_date") startDate: String,
    @Query ("end_date") endDate: String,
    @Query ("symbols") symbols: String,
): HistoryDto


}