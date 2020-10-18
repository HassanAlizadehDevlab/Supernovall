package com.android.data.assets

import android.content.Context
import java.io.InputStream
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class Loader @Inject constructor(private val context: Context) : AssetsLoader {
    override fun open(path: String): InputStream {
        return context.assets.open(path)
    }
}