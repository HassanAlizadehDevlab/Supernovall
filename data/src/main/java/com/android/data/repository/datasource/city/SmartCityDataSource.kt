package com.android.data.repository.datasource.city

import com.android.data.assets.AssetsLoader
import com.android.data.entity.model.local.City
import com.android.data.trie.Trie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class SmartCityDataSource @Inject constructor(
    private val assets: AssetsLoader
) : CityDataSource {
    private val cityTrie = Trie<City>()


    override fun cacheCities(): Boolean {
        try {
            loadFromAssets(CITIES_FILE).forEach { city ->
                cityTrie.insert(city, city.name)
            }
        } catch (e: Exception) {
            return false
        }
        return true
    }

    private fun loadFromAssets(path: String): List<City> {
        val reader = InputStreamReader(assets.open(path))
        val typeToken = object : TypeToken<List<City>>() {}.type
        return Gson().fromJson<List<City>>(reader, typeToken)
    }

    companion object {
        private const val CITIES_FILE = "cities.json"
    }
}