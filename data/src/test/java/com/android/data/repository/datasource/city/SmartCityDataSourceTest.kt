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
    fun `load cities in trie`() {
        // GIVEN
        doReturn(TestUtils.cityStream()).whenever(assetsLoader).open(anyString())

        // WHEN
        val isSuccess = dataSource.cacheCities()

        // THEN
        assert(isSuccess)
    }


}