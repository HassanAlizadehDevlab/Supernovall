package com.android.data.assets

import android.content.Context
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class Loader @Inject constructor(private val context: Context) : AssetsLoader {
    override fun load(path: String) {
        context.assets.open(path)
    }
}