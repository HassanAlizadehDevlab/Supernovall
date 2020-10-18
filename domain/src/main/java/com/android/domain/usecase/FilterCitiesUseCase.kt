package com.android.domain.usecase

import com.android.domain.entity.CityObject
import com.android.domain.repository.CityRepository
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class FilterCitiesUseCase @Inject constructor(
    private val repository: CityRepository
) : UseCase<List<CityObject>, String>() {
    override fun execute(param: String?): List<CityObject> {
        return repository.getCities(prefix = param ?: "")
    }
}