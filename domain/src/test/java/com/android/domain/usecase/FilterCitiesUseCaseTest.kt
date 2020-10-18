package com.android.domain.usecase

import com.android.common_test.TestUtils
import com.android.data.entity.mapper.map
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
class FilterCitiesUseCaseTest {

    @Mock
    private lateinit var repository: CityRepository
    private lateinit var useCase: FilterCitiesUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        useCase = FilterCitiesUseCase(repository)
    }


    @Test
    fun execute() {
        // GIVEN
        val prefix = "A"
        val cityList = TestUtils.filter(prefix).map()
        doReturn(cityList).whenever(repository).getCities(anyString())

        // WHEN

        val result = useCase.invoke(prefix)

        // THEN
        verify(repository).getCities(prefix)
        result.forEach { assert(it.name.startsWith(prefix)) }
    }

    @Test
    fun `execute on empty prefix`() {
        // GIVEN
        val prefix = ""
        val cityList = TestUtils.filter(prefix).map()
        doReturn(cityList).whenever(repository).getCities(anyString())

        // WHEN
        val result = useCase.invoke(prefix)

        // THEN
        verify(repository).getCities(prefix)
        println(result.size)
        result.forEach { assert(it.name.startsWith(prefix)) }
    }

}