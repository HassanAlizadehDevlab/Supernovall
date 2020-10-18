package com.android.data.entity.mapper

import com.android.data.entity.model.local.City
import com.android.data.entity.model.local.Coord
import com.android.domain.entity.CityObject
import com.android.domain.entity.CoordObject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
fun List<City>.map() = map { it.map() }
fun City.map() = CityObject(_id = _id, name = name, country = country, coord = coord.map())
fun Coord.map() = CoordObject(lon = lon, lan = lan)