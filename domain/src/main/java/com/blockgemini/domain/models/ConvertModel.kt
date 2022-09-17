package com.blockgemini.domain.models

data class ConvertModel(
    val date: String?,
    val result: Double?,
    val rate: Double?,
    val timestamp: Int?,
    val amount: Int?,
    val from: String?,
    val to: String?,
)
