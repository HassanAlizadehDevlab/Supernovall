package com.android.data.repository.datasource.city

import com.android.common_test.TestUtils
import com.android.data.assets.AssetsLoader
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by hassanalizadeh on 18,October,2020
 */
@RunWith(JUnit4::class)
class SmartCityDataSourceTest {

    @Mock
    private lateinit var assetsLoader: AssetsLoader
    private lateinit var dataSource: SmartCityDataSource


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        dataSource = spy(SmartCityDataSource(assetsLoader))
    }


    @Test
    fun `city list size by prefix "A" filter is 3`() {
        // GIVEN
        val prefix = "A"
        val trie = TestUtils.cityTrie()
        dataSource.cityTrie = trie

        // WHEN
        val cities = dataSource.getCities(prefix)

        // THEN
        assert(cities.size == TestUtils.lengthOfCityListWith_A_Prefix())
        cities.forEach {
            assert(it.name.startsWith(prefix))
        }
    }


    @Test
    fun `filter cities by prefix "a" is case sensitive`() {
        // GIVEN
        val prefix = "a"
        val trie = TestUtils.cityTrie()
        dataSource.cityTrie = trie

        // WHEN
        val cities = dataSource.getCities(prefix)

        // THEN
        assert(cities.size == TestUtils.lengthOfCityListWith_a_Prefix())
        cities.forEach {
            assert(it.name.startsWith(prefix))
        }
    }


    @Test
    fun `filter cities by prefix J`() {
        // GIVEN
        val prefix = "J"
        val trie = TestUtils.cityTrie()
        dataSource.cityTrie = trie

        // WHEN
        val cities = dataSource.getCities(prefix)

        // THEN
        assert(cities.size == TestUtils.lengthOfCityListWith_J_Prefix())
        cities.forEach {
            assert(it.name.startsWith(prefix))
        }
    }

    @Test
    fun `load cities in trie`() {
        // GIVEN
        doReturn(TestUtils.cityStream()).whenever(assetsLoader).open(anyString())

        // WHEN
        val isSuccess = dataSource.cacheCities()

        // THEN
        assert(isSuccess)
    }


}