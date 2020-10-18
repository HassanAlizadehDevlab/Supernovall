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

    fun lengthOfCityListWithPrefix(prefix: String) =
        cityList().filter { it.name.startsWith(prefix) }.size


    fun filter(prefix: String): List<City> {
        return cityList().filter { it.name.startsWith(prefix) }
    }

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