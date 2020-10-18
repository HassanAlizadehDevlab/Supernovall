package com.android.presentation.ui.spash

import androidx.lifecycle.MutableLiveData
import com.android.domain.usecase.CacheCitiesUseCase
import com.android.domain.usecase.invoke
import com.android.presentation.common.view.BaseViewModel
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class SplashViewModel @Inject constructor(
    private val cacheCitiesUseCase: CacheCitiesUseCase
) : BaseViewModel() {

    val isFinished = MutableLiveData<Boolean>()

    init {
        cacheCities()
    }

    private fun cacheCities() {
        val thread = Thread {
            val success = cacheCitiesUseCase.invoke()
            isFinished.postValue(success)
        }.apply {
            track()
        }

        thread.start()
    }

}