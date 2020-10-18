package com.android.domain.usecase

import com.android.domain.repository.CityRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by hassanalizadeh on 19,October,2020
 */
@RunWith(JUnit4::class)
class CacheCitiesUseCaseTest {

    @Mock
    private lateinit var repository: CityRepository
    private lateinit var useCase: CacheCitiesUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        useCase = CacheCitiesUseCase(repository)
    }


    @Test
    fun execute() {
        // GIVEN
        val success = true
        doReturn(success).whenever(repository).cacheCities()

        // WHEN
        val result = useCase.invoke()

        // THEN
        verify(repository).cacheCities()
        assert(result == success)
    }

}