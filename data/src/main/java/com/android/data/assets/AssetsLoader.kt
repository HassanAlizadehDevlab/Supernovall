package com.android.data.assets

import java.io.InputStream

/**
 * Created by hassanalizadeh on 18,October,2020
 */
interface AssetsLoader {
    fun open(path: String): InputStream
}