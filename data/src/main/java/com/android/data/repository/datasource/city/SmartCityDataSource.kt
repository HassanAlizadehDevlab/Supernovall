package com.android.data.repository.datasource.city

import androidx.annotation.VisibleForTesting
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

    @VisibleForTesting
    var cityTrie: Trie<City>? = null


    override fun getCities(prefix: String): List<City> {
        if (cityTrie == null) cacheCities()
        return cityTrie?.findWords(prefix) ?: mutableListOf()
    }

    override fun cacheCities(): Boolean {
        try {
            cityTrie = Trie()
            // loadFromAssets(CITIES_FILE).sortedBy { it.name }.forEach { city -> }
            // We can sort it here when the data wa loaded and we want to insert it into the Trie
            // We can use sortBy function or even we can implement our sorting algorithms
            // I liked to do it. But I didn't have enough time to handle this.
            loadFromAssets(CITIES_FILE).forEach { city ->
                cityTrie?.insert(city, city.name)
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