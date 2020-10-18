package com.android.presentation.ui.spash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.android.presentation.R
import com.android.presentation.common.extension.observe
import com.android.presentation.common.extension.toast
import com.android.presentation.common.extension.viewModelProvider
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class SplashFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelProvider(factory)

        observe(viewModel.isFinished, ::observe)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_splash, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startAnimating()
    }

    private fun observe(status: Boolean) {
        if (status)
            navigator.showCityList()
        else {
            activityContext.toast(R.string.error)
            navigator.onBackPressed()
        }
    }

    private fun startAnimating() {
        val fadeOut = AlphaAnimation(1.0f, 0.0f)
        fadeOut.repeatCount = Animation.INFINITE
        fadeOut.repeatMode = Animation.RESTART
        fadeOut.duration = 1000
        fadeOut.interpolator = AccelerateInterpolator()

        txtLoading.startAnimation(fadeOut)
    }

    companion object {
        fun newInstance(): SplashFragment = SplashFragment()
    }

}