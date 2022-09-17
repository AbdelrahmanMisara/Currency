package com.blockgemini.data.mappers

import com.blockgemini.data.dto.ConvertDto
import com.blockgemini.data.dto.HistoryDto
import com.blockgemini.data.dto.LatestDto
import com.blockgemini.domain.models.*

fun LatestDto.toModel() = LatestModel(
    base, date, rates, timestamp,rates?.map {
        Currency(it.key, it.value.toString())
    }
)

fun ConvertDto.toModel() = ConvertModel(
    date,result,info?.rate,info?.timestamp,query?.amount,query?.from,query?.to
)

fun HistoryDto.toModel() = HistoryModel(
    base, endDate,  startDate, rates.map {
        val keys = it.value.keys.toList()
        val values = it.value.values.toList()
        Rate(date = it.key, keys[0],values[0].toString(),keys[1],values[1].toString())
    }
)