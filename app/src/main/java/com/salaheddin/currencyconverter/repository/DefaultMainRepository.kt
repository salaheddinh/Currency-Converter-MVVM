package com.salaheddin.currencyconverter.repository

import com.salaheddin.currencyconverter.data.models.CurrencyResponse
import com.salaheddin.currencyconverter.data.network.CurrencyAPI
import com.salaheddin.currencyconverter.utils.Resource
import java.lang.Exception
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyAPI
) : MainRepository {

    override suspend fun getRates(fromCurrency: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(fromCurrency)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "General Error Occurred")
        }
    }
}