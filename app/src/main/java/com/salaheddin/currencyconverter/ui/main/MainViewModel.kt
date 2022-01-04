package com.salaheddin.currencyconverter.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salaheddin.currencyconverter.data.models.Data
import com.salaheddin.currencyconverter.repository.MainRepository
import com.salaheddin.currencyconverter.utils.DispatcherProvider
import com.salaheddin.currencyconverter.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    sealed class CurrencyEvent {
        class Success(val result: Double) : CurrencyEvent()
        class Failure(val message: String) : CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversionResult = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
    val conversionResult: StateFlow<CurrencyEvent> = _conversionResult

    fun convertCurrency(amountString: String, fromCurrency: String, toCurrency: String) {
        val amount = amountString.toFloatOrNull()
        if (amount == null) {
            _conversionResult.value = CurrencyEvent.Failure("Amount not valid")
            return
        }

        viewModelScope.launch(dispatchers.io) {
            _conversionResult.value = CurrencyEvent.Loading
            when (val ratesResponse = repository.getRates(fromCurrency)) {
                is Resource.Error -> _conversionResult.value =
                    CurrencyEvent.Failure(ratesResponse.message!!)
                is Resource.Success -> {
                    val rates = ratesResponse.data!!.data
                    val rate = getRateForCurrency(toCurrency, rates)
                    if (rate == null) {
                        _conversionResult.value = CurrencyEvent.Failure("Unexpected Error")
                    } else {
                        val convertedAmount = (amount * rate * 100) / 100
                        _conversionResult.value = CurrencyEvent.Success(convertedAmount)
                    }
                    /*rate?.let {
                        val convertedAmount = (amount * rate * 100) / 100
                        _conversionResult.value = CurrencyEvent.Success(convertedAmount)
                    } ?: run {
                        _conversionResult.value = CurrencyEvent.Failure("Unexpected Error")
                    }*/
                }
            }
        }
    }

    private fun getRateForCurrency(currency: String, rates: Data) = when (currency) {
        //"CAD" -> rates.CAD
        "EUR" -> rates.EUR
       /* "HKD" -> rates.HKD
        "ISK" -> rates.ISK
        "PHP" -> rates.PHP
        "DKK" -> rates.DKK
        "HUF" -> rates.HUF
        "CZK" -> rates.CZK
        "AUD" -> rates.AUD
        "RON" -> rates.RON
        "SEK" -> rates.SEK
        "IDR" -> rates.IDR
        "INR" -> rates.INR
        "BRL" -> rates.BRL
        "RUB" -> rates.RUB
        "JPY" -> rates.JPY
        "THB" -> rates.THB
        "CHF" -> rates.CHF
        "SGD" -> rates.SGD
        "PLN" -> rates.PLN
        "BGN" -> rates.BGN
        "CNY" -> rates.CNY
        "NOK" -> rates.NOK
        "NZD" -> rates.NZD
        "ZAR" -> rates.ZAR
        //"USD" -> rates.USD
        "MXN" -> rates.MXN
        "GBP" -> rates.GBP
        "KRW" -> rates.KRW
        "MYR" -> rates.MYR*/
        else -> null
    }
}