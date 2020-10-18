package com.android.domain.usecase

import com.android.domain.repository.CityRepository
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CacheCitiesUseCase @Inject constructor(
    private val repository: CityRepository
) : UseCase<Boolean, Unit>() {
    override fun execute(param: Unit?): Boolean {
        return repository.cacheCities()
    }
}