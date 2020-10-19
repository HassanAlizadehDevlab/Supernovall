package com.android.presentation.ui.city

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.common_test.TestUtils
import com.android.common_test.observe
import com.android.data.entity.mapper.map
import com.android.domain.entity.CityObject
import com.android.domain.usecase.FilterCitiesUseCase
import com.nhaarman.mockitokotlin2.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers.anyString

/**
 * Created by hassanalizadeh on 19,October,2020
 */
@RunWith(JUnit4::class)
class CityViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val filterCitiesUseCase: FilterCitiesUseCase = mock()
    private lateinit var viewModel: CityViewModel


    private fun createViewModel() {
        viewModel = CityViewModel(
            filterCitiesUseCase
        )
    }

    @Test
    fun `success caching cities`() {
        // GIVEN
        val prefix = "A"
        val cities = TestUtils.filter(prefix).map()
        doReturn(cities).whenever(filterCitiesUseCase).invoke(anyString())
        val citiesObserver = mock<(List<CityObject>) -> Unit>()
        createViewModel()
        viewModel.cities.observe(citiesObserver)

        // WHEN
        viewModel.filter(prefix)

        // THEN
        verify(filterCitiesUseCase).invoke(prefix)
        verify(citiesObserver).invoke(argThat {
            this.size == cities.size
        })
        viewModel.cities.value?.forEach { assert(it.name.startsWith(prefix)) }
    }

    @Test
    fun `filter by 2 different prefix`() {
        // GIVEN
        val prefix1 = "A"
        val prefix2 = "B"
        val cities1 = TestUtils.filter(prefix1).map()
        val cities2 = TestUtils.filter(prefix2).map()
        doReturn(cities1).whenever(filterCitiesUseCase).invoke(prefix1)
        doReturn(cities2).whenever(filterCitiesUseCase).invoke(prefix2)
        val citiesObserver = mock<(List<CityObject>) -> Unit>()
        createViewModel()
        viewModel.cities.observe(citiesObserver)

        // WHEN
        viewModel.filter(prefix1)
        viewModel.filter(prefix2)

        // THEN
        verify(filterCitiesUseCase).invoke(prefix1)
        verify(filterCitiesUseCase).invoke(prefix2)
        viewModel.cities.value?.forEach { assert(it.name.startsWith(prefix2)) }
    }

    @Test
    fun `items not found among cities`() {
        // GIVEN
        val prefix = "Abddjsjh"
        val cities = TestUtils.filter(prefix).map()
        doReturn(cities).whenever(filterCitiesUseCase).invoke(anyString())
        val citiesObserver = mock<(List<CityObject>) -> Unit>()
        createViewModel()
        viewModel.cities.observe(citiesObserver)

        // WHEN
        viewModel.filter(prefix)

        // THEN
        verify(filterCitiesUseCase).invoke(prefix)
        assert(viewModel.cities.value?.isEmpty() == true)
    }
}