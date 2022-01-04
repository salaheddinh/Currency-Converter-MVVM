package com.salaheddin.currencyconverter.repository

import com.salaheddin.currencyconverter.data.models.CurrencyResponse
import com.salaheddin.currencyconverter.utils.Resource


interface MainRepository {
    suspend fun getRates(fromCurrency: String): Resource<CurrencyResponse>
}