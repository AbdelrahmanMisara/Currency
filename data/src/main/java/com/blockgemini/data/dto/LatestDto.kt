package com.blockgemini.data.dto


import com.google.gson.annotations.SerializedName

data class LatestDto(
    @SerializedName("base")
    var base: String? = "",
    @SerializedName("date")
    var date: String? = "",
    @SerializedName("success")
    var success: Boolean? = false,
    @SerializedName("rates")
    var rates: Map<String,Double>? = hashMapOf(),
    @SerializedName("timestamp")
    var timestamp: Int? = 0
)