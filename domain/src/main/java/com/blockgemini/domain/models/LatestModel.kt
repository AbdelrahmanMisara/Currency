package com.blockgemini.domain.models

data class LatestModel (
        val base: String?,
        val date: String?,
        val rates: Map<String,Double>?,
        val timestamp: Int?,
        val currencies: List<Currency>?
        )

data class Currency(
        val symbol: String,
        val value: String
)