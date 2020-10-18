package com.android.common_test

import com.android.data.entity.model.local.City
import com.android.data.trie.Trie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by hassanalizadeh on 15,October,2020
 */
object TestUtils {

    fun lengthOfCityListWith_A_Prefix() = cityList().filter { it.name.startsWith("A") }.size
    fun lengthOfCityListWith_a_Prefix() = cityList().filter { it.name.startsWith("a") }.size
    fun lengthOfCityListWith_J_Prefix()= cityList().filter { it.name.startsWith("J") }.size

    fun cityTrie(): Trie<City> {
        val trie = Trie<City>()
        cityList().forEach { trie.insert(it, it.name) }
        return trie
    }

    fun cityList(): List<City> {
        val reader = InputStreamReader(cityStream())
        val typeToken = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson<List<City>>(reader, typeToken)
    }

    fun cityStream(): InputStream? {
        return javaClass.classLoader?.getResourceAsStream("json/cities.json")
    }

    private fun parseJson(fileName: String): String =
        javaClass.classLoader?.getResourceAsStream("json/$fileName")
            ?.bufferedReader().use { it?.readText().orEmpty() }

}