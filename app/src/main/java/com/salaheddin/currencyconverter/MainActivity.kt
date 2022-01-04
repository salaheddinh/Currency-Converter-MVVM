package com.salaheddin.currencyconverter

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.salaheddin.currencyconverter.utils.getDrawableFromAssets
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
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
                        getDrawableFromAssets(items[index].lowercase() + ".png")
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
                        getDrawableFromAssets(items[index].lowercase() + ".png")
                    flagDrawable?.let {
                        ivToCurrency.setImageDrawable(it)
                    }
                    dialog.dismiss()
                }.create().show()
        }
    }
}