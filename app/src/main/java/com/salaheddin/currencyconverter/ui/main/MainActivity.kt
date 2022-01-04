package com.salaheddin.currencyconverter.ui.main

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.salaheddin.currencyconverter.R
import com.salaheddin.currencyconverter.utils.getDrawableFromAssets
import kotlinx.android.synthetic.main.activity_main.*
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        initObservables()
    }

    private fun initObservables() {
        lifecycleScope.launchWhenStarted {
            viewModel.conversionResult.collect { currencyEvent ->
                when (currencyEvent) {
                    is MainViewModel.CurrencyEvent.Success -> {
                        cvResult.visibility = View.VISIBLE
                        tvConversionResult.text = "${currencyEvent.result}"
                    }
                    is MainViewModel.CurrencyEvent.Failure -> {
                        Toast.makeText(this@MainActivity, currencyEvent.message, Toast.LENGTH_LONG)
                            .show()
                    }
                    is MainViewModel.CurrencyEvent.Loading -> {

                    }
                    else -> Unit
                }
            }
        }
    }

    private fun init() {
        setupCurrencyDialogs()
        setupConvertBtn()
    }

    private fun setupConvertBtn() {
        tvConvert.setOnClickListener {
            viewModel.convertCurrency(
                etFromCurrency.text.toString(),
                "USD",
                "EUR"
            )
        }
    }

    private fun setupCurrencyDialogs() {
        val items = resources.getStringArray(R.array.currency_codes)
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item, items
        )

        ivFromCurrency.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.from))
                .setSingleChoiceItems(
                    adapter,
                    0,
                ) { dialog, index ->
                    tvFromCurrency.text = items[index]
                    val flagDrawable =
                        getDrawableFromAssets(items[index].toLowerCase(Locale.getDefault()) + ".png")
                    flagDrawable?.let {
                        ivFromCurrency.setImageDrawable(it)
                    }
                    dialog.dismiss()
                }.create().show()
        }

        ivToCurrency.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.to))
                .setSingleChoiceItems(
                    adapter,
                    0,
                ) { dialog, index ->
                    tvToCurrency.text = items[index]
                    val flagDrawable =
                        getDrawableFromAssets(items[index].toLowerCase(Locale.getDefault()) + ".png")
                    flagDrawable?.let {
                        ivToCurrency.setImageDrawable(it)
                    }
                    dialog.dismiss()
                }.create().show()
        }
    }
}