package com.android.data.repository

import com.android.data.repository.datasource.DataSourceModule
import com.android.domain.repository.CityRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

/**
 * Created by hassanalizadeh on 19,September,2020
 */
@Module(includes = [DataSourceModule::class])
abstract class RepositoryModule {

    @Binds
    @Reusable
    abstract fun provideCityRepository(
        cityRepositoryImpl: CityRepositoryImpl
    ): CityRepository

}