package com.salaheddin.currencyconverter.data.models

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("query")
    val query: Query
)