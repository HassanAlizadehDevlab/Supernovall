package com.android.presentation.ui.spash

import androidx.lifecycle.ViewModel
import com.android.presentation.common.di.FragmentScope
import com.android.presentation.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by hassanalizadeh on 19,October,2020
 */
@Module
abstract class SplashViewModelModule {
    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(SplashViewModel::class)
    abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel
}