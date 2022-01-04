package com.salaheddin.currencyconverter.network

import com.salaheddin.currencyconverter.utils.Constants.Companion.API_Key
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "us",
        @Query("page")
        page: String = "us",
        @Query("apiKey")
        apiKey: String = API_Key
    )

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        countryCode: String,
        @Query("page")
        page: String = "us",
        @Query("apiKey")
        apiKey: String = API_Key
    )
}