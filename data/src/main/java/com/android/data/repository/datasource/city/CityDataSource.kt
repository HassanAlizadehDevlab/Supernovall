package com.android.data.repository.datasource.city

import com.android.data.entity.model.local.City

/**
 * Created by hassanalizadeh on 18,October,2020
 */
interface CityDataSource {
    fun getCities(prefix: String): List<City>
    fun cacheCities(): Boolean
}