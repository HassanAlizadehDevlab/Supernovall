package com.android.presentation.common.navigator

import androidx.fragment.app.FragmentManager
import com.android.presentation.R
import com.android.presentation.common.extension.addFragment
import com.android.presentation.common.view.BaseActivityModule
import com.android.presentation.ui.spash.SplashFragment
import javax.inject.Inject
import javax.inject.Named

/**
 * Handle all navigation in here.
 *
 * @param fragmentManager is [MainActivity]'s fragmentManager.
 */
class Navigator @Inject constructor(
    @Named(BaseActivityModule.ACTIVITY_FRAGMENT_MANAGER)
    private val fragmentManager: FragmentManager
) {

    fun showSplash() {
        fragmentManager.addFragment(
            containerViewId = R.id.fragmentContainer,
            fragment = SplashFragment.newInstance()
        )
    }

}