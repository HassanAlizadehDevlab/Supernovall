package com.android.presentation.ui.city

import androidx.lifecycle.MutableLiveData
import com.android.domain.entity.CityObject
import com.android.domain.usecase.FilterCitiesUseCase
import com.android.presentation.common.view.BaseViewModel
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CityViewModel @Inject constructor(
    private val filterCitiesUseCase: FilterCitiesUseCase
) : BaseViewModel() {

    val cities = MutableLiveData<List<CityObject>>()

    fun filter(prefix: String) {
        // Interrupt all threads
        clearThreads()

        val thread = Thread {
            try {
                val result = filterCitiesUseCase.invoke(prefix)
                if (Thread.interrupted()) return@Thread
                cities.postValue(result)
            } catch (e: Exception) {
                // Do nothing
                println("Thread: stopped")
            }
        }

        thread.track()
        thread.start()
    }

}