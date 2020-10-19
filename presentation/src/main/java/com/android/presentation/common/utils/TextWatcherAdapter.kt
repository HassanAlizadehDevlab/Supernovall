package com.android.presentation.common.utils

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by hassanalizadeh on 19,October,2020
 */
abstract class TextWatcherAdapter : TextWatcher {
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }
}