package com.android.data

import com.android.data.repository.RepositoryModule
import dagger.Module

/**
 * Created by hassanalizadeh on 19,September,2020
 */
@Module(
    includes = [
        RepositoryModule::class
    ]
)
abstract class DataModule