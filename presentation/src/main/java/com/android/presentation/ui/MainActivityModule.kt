package com.android.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.android.presentation.common.di.ActivityScope
import com.android.presentation.common.di.FragmentScope
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.city.CityFragment
import com.android.presentation.ui.city.CityFragmentModule
import com.android.presentation.ui.map.MapFragment
import com.android.presentation.ui.map.MapFragmentModule
import com.android.presentation.ui.spash.SplashFragment
import com.android.presentation.ui.spash.SplashFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by hassanalizadeh on 18,October,2020
 */
@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [SplashFragmentModule::class])
    abstract fun splashFragmentInjector(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [CityFragmentModule::class])
    abstract fun cityFragmentInjector(): CityFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [MapFragmentModule::class])
    abstract fun mapFragmentInjector(): MapFragment


    /**
     * Bind it just once˚
     * This is used with Dagger MultiBinding
     * */
    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @ActivityScope
    abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity

}