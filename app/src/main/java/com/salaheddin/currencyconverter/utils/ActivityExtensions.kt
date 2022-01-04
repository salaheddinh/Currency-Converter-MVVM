package com.salaheddin.currencyconverter.utils

import android.content.Context
import android.graphics.drawable.Drawable
import java.io.IOException
import java.io.InputStream

fun Context.getDrawableFromAssets(assetName: String): Drawable? {
    return try {
        val ims: InputStream = assets.open(assetName)
        Drawable.createFromStream(ims, null)
    } catch (ex: IOException) {
        null
    }
}