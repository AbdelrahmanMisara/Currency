package com.blockgemini.domain.models

data class HistoryModel(
    val base: String?,
    val endDate: String?,
    val startDate: String?,
    val rates: List<Rate>?
)

data class Rate(
    val date: String,
    val from: String,
    val fromValue: String,
    val to: String,
    val toValue: String
)
