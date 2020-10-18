package com.android.data.repository

import com.android.common_test.TestUtils
import com.android.data.repository.datasource.city.CityDataSource
import com.android.domain.entity.CityObject
import com.android.domain.repository.CityRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by hassanalizadeh on 19,October,2020
 */
@RunWith(JUnit4::class)
class CityRepositoryImplTest {

    @Mock
    private lateinit var dataSource: CityDataSource
    private lateinit var repository: CityRepository


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = CityRepositoryImpl(dataSource)
    }


    @Test
    fun `city list size by prefix "A" filter is 3 and type is CityObject`() {
        // GIVEN
        val prefix = "A"
        val filterCities = TestUtils.filter(prefix)
        doReturn(filterCities).whenever(dataSource).getCities(anyString())

        // WHEN
        val cities = repository.getCities(prefix)

        // THEN
        verify(dataSource).getCities(prefix)
        assert(cities.size == TestUtils.lengthOfCityListWithPrefix(prefix))
        cities.forEach {
            assert(it is CityObject)
            assert(it.name.startsWith(prefix))
        }
    }

    @Test
    fun `cache cities is successful`() {
        // GIVEN
        val success = true
        doReturn(success).whenever(dataSource).cacheCities()

        // WHEN
        val isSuccess = repository.cacheCities()

        // THEN
        verify(dataSource).cacheCities()
        assert(isSuccess == success)
    }

}