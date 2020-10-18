package com.android.presentation.ui

import com.android.presentation.common.di.FragmentScope
import com.android.presentation.common.view.BaseActivityModule
import com.android.presentation.ui.spash.SplashFragment
import com.android.presentation.ui.spash.SplashFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by hassanalizadeh on 18,October,2020
 */
@Module(
    includes = [
        BaseActivityModule::class
    ]
)
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [SplashFragmentModule::class])
    abstract fun splashFragmentInjector(): SplashFragment

}