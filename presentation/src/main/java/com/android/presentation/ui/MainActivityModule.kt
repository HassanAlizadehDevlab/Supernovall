package com.android.presentation.ui

import android.content.Context
import com.android.presentation.common.di.ActivityScope
import dagger.Binds
import dagger.Module

/**
 * Created by hassanalizadeh on 18,October,2020
 */
@Module
abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract fun activityScope(activity: MainActivity): Context


}