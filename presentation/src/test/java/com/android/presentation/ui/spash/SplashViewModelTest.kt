package com.android.presentation.ui.spash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.common_test.observe
import com.android.domain.usecase.CacheCitiesUseCase
import com.android.domain.usecase.invoke
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by hassanalizadeh on 19,October,2020
 */
@RunWith(JUnit4::class)
class SplashViewModelTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val cacheCitiesUseCase: CacheCitiesUseCase = mock()
    private lateinit var viewModel: SplashViewModel


    private fun createViewModel() {
        viewModel = SplashViewModel(
            cacheCitiesUseCase
        )
    }

    @Test
    fun `success caching cities`() {
        // GIVEN
        val success = true
        doReturn(success).whenever(cacheCitiesUseCase).invoke()
        val loadingObserver = mock<(Boolean) -> Unit>()
        createViewModel()
        viewModel.isFinished.observe(loadingObserver)

        // WHEN
        // It's calling automatically
        // viewModel.cacheCities()

        // THEN
        verify(loadingObserver).invoke(success)
    }


}