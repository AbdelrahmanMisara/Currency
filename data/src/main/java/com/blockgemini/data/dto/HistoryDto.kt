package com.blockgemini.data.dto


import com.google.gson.annotations.SerializedName

data class HistoryDto(
    @SerializedName("base")
    var base: String? = "",
    @SerializedName("end_date")
    var endDate: String? = "",
    @SerializedName("rates")
    var rates: Map<String,Map<String,Double>> = hashMapOf(),
    @SerializedName("start_date")
    var startDate: String? = "",
    @SerializedName("success")
    var success: Boolean? = false,
    @SerializedName("timeseries")
    var timeseries: Boolean? = false
)