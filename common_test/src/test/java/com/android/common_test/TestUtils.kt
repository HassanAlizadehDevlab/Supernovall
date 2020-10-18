package com.android.common_test

/**
 * Created by hassanalizadeh on 15,October,2020
 */
object TestUtils {

    private fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it?.readText().orEmpty() }

}