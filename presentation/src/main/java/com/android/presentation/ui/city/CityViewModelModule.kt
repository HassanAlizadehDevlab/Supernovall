package com.android.presentation.ui.city

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
abstract class CityViewModelModule {
    @Binds
    @IntoMap
    @FragmentScope
    @ViewModelKey(CityViewModel::class)
    abstract fun cityViewModel(viewModel: CityViewModel): ViewModel
}