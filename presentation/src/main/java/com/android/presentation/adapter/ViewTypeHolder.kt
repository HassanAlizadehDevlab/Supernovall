package com.android.presentation.adapter

import com.android.domain.entity.CityObject
import com.android.domain.entity.DomainObject
import com.android.presentation.R

/**
 * Created by hassanalizadeh on 26,February,2019
 */
object ViewTypeHolder {

    fun getView(obj: DomainObject?): Int {
        if (obj == null) return 0
        return when (obj) {
            is CityObject -> R.layout.adapter_city

            else -> 0
        }
    }
}
