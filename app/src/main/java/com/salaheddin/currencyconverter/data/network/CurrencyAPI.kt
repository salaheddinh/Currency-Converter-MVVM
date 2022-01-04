package com.salaheddin.currencyconverter.data.network

import com.salaheddin.currencyconverter.data.models.CurrencyResponse
import com.salaheddin.currencyconverter.utils.Constants.Companion.API_Key
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyAPI {

    @GET("api/v2/latest")
    suspend fun getRates(
        @Query("base_currency")
        baseCurrency: String,
        @Query("apikey")
        apikey: String = API_Key
    ): Response<CurrencyResponse>
}