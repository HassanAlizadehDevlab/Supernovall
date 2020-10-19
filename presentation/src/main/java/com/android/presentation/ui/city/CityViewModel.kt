package com.android.presentation.ui.city

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.domain.entity.CityObject
import com.android.domain.usecase.FilterCitiesUseCase
import com.android.presentation.adapter.BaseAction
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CityViewModel @Inject constructor(
    private val filterCitiesUseCase: FilterCitiesUseCase
) : ViewModel() {
    val cities = MutableLiveData<List<CityObject>>()
    val clickObserver = MutableLiveData<BaseAction>()

    fun filter(prefix: String = "") {
        val thread = Thread {
            try {
                val result = filterCitiesUseCase.invoke(prefix)
                cities.postValue(result)
            } catch (e: InterruptedException) {
                cities.postValue(mutableListOf())
            }
        }

        thread.start()
    }

    fun clickObserver(action: BaseAction) {
        clickObserver.value = action
    }

}