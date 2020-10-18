package com.android.supernovall

import android.content.Context
import com.android.presentation.common.di.ActivityScope
import com.android.presentation.ui.MainActivity
import com.android.presentation.ui.MainActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

/**
 * Created by hassanalizadeh on 19,September,2020
 */
@Module(includes = [AndroidInjectionModule::class])
abstract class SupernovaModule {

    @Binds
    @Singleton
    abstract fun context(application: Supernova): Context

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivityInjector(): MainActivity

}