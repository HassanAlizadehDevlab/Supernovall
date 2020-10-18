package com.android.data.repository.city

import com.android.data.entity.mapper.map
import com.android.data.repository.datasource.city.CityDataSource
import com.android.domain.entity.CityObject
import com.android.domain.repository.CityRepository
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CityRepositoryImpl @Inject constructor(
    private val dataSource: CityDataSource
) : CityRepository {
    override fun getCities(prefix: String): List<CityObject> {
        return dataSource.getCities(prefix).map()
    }

    override fun cacheCities(): Boolean {
        return dataSource.cacheCities()
    }
}