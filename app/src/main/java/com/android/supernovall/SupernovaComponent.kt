package com.android.supernovall

import com.android.data.DataModule
import com.android.domain.DomainModule
import com.android.presentation.PresentationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by hassanalizadeh on 18,October,2020
 */
@Singleton
@Component(
    modules = [
        SupernovaModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface SupernovaComponent : AndroidInjector<Supernova> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Supernova): SupernovaComponent
    }

}