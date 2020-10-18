package com.android.data.repository.datasource

import com.android.data.repository.datasource.city.CityDataSource
import com.android.data.repository.datasource.city.SmartCityDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by hassanalizadeh on 19,September,2020
 */
@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideCityDataSource(dataSource: SmartCityDataSource): CityDataSource

}