package com.android.data.assets

import dagger.Binds
import dagger.Module
import dagger.Reusable

/**
 * Created by hassanalizadeh on 18,October,2020
 */
@Module
abstract class AssetsModule {

    @Binds
    @Reusable
    abstract fun provideAssetsLoader(loader: Loader): AssetsLoader

}