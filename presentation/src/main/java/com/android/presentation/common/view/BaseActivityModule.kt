package com.android.presentation.common.view

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.android.presentation.common.di.ActivityScope
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class BaseActivityModule {

    /**
     * Bind it just once
     * This is used with Dagger MultiBinding
     * */
    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory


    @Module
    companion object {

        const val ACTIVITY_FRAGMENT_MANAGER = "MainActivityFragmentManager"

        @JvmStatic
        @Provides
        @Named(ACTIVITY_FRAGMENT_MANAGER)
        @ActivityScope
        fun provideActivityFragmentManager(activity: MainActivity): FragmentManager {
            return activity.supportFragmentManager
        }
    }

}