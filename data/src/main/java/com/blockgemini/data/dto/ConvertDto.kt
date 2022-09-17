package com.blockgemini.data.dto


import com.google.gson.annotations.SerializedName

data class ConvertDto(
    @SerializedName("date")
    var date: String? = "",
    @SerializedName("info")
    var info: Info? = Info(),
    @SerializedName("query")
    var query: Query? = Query(),
    @SerializedName("result")
    var result: Double? = 0.0,
    @SerializedName("success")
    var success: Boolean? = false
)

data class Info(
    @SerializedName("rate")
    var rate: Double? = 0.0,
    @SerializedName("timestamp")
    var timestamp: Int? = 0
)

data class Query(
    @SerializedName("amount")
    var amount: Int? = 0,
    @SerializedName("from")
    var from: String? = "",
    @SerializedName("to")
    var to: String? = ""
)