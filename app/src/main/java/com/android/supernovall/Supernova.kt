package com.android.supernovall

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class Supernova : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerSupernovaComponent.factory().create(this)

}