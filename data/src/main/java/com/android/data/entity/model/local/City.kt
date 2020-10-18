package com.android.data.entity.model.local

/**
 * Created by hassanalizadeh on 18,October,2020
 */
data class City(
    val _id: Int,
    val name: String,
    val country: String,
    val coord: Coord
) {

    override fun toString(): String {
        return "City=$name && $_id"
    }

}