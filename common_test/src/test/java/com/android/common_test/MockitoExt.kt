package com.android.common_test

import androidx.lifecycle.LiveData

/**
 * a kotlin friendly mock that handles generics
 */
fun <T> LiveData<T>.observe(onChangeHandler: (T) -> Unit) {
    val observer = UnlimitedObserver(handler = onChangeHandler)
    observe(observer, observer)
}
