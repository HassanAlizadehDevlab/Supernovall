package com.android.presentation.common.view

import androidx.lifecycle.ViewModel

/**
 * Base class for all ViewModels.
 */
abstract class BaseViewModel : ViewModel() {

    private val disposable = mutableListOf<Thread>()


    protected fun Thread.track() {
        disposable.add(this)
    }

    protected fun clearThreads() {
        disposable.forEach { it.interrupt() }
        disposable.clear()
    }

    override fun onCleared() {
        super.onCleared()
        clearThreads()
    }
}