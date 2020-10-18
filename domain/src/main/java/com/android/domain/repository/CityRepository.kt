package com.android.domain.repository

import com.android.domain.entity.CityObject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
interface CityRepository {
    fun getCities(prefix: String): List<CityObject>
    fun cacheCities(): Boolean
}