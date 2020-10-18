package com.android.domain.entity

/**
 * Created by hassanalizadeh on 19,October,2020
 */
data class CityObject(
    val _id: Int,
    val name: String,
    val country: String,
    val coord: CoordObject
) : DomainObject