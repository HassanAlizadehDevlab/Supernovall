package com.android.presentation.common.navigator

import androidx.appcompat.app.AppCompatActivity
import com.android.presentation.R
import com.android.presentation.common.extension.addFragment
import com.android.presentation.common.extension.replaceFragment
import com.android.presentation.ui.MainActivity
import com.android.presentation.ui.city.CityFragment
import com.android.presentation.ui.map.MapFragment
import com.android.presentation.ui.spash.SplashFragment
import javax.inject.Inject

/**
 * Handle all navigation in here.
 *
 * @param fragmentManager is [MainActivity]'s fragmentManager.
 */
class Navigator @Inject constructor(
    private val activity: AppCompatActivity
) {
    private val fragmentManager = activity.supportFragmentManager

    fun showSplash() {
        fragmentManager.addFragment(
            containerViewId = R.id.fragmentContainer,
            fragment = SplashFragment.newInstance()
        )
    }

    fun showCityList() {
        fragmentManager.replaceFragment(
            containerViewId = R.id.fragmentContainer,
            fragment = CityFragment.newInstance()
        )
    }

    fun showMap(name: String, lat: Double, lon: Double) {
        fragmentManager.addFragment(
            containerViewId = R.id.fragmentContainer,
            fragment = MapFragment.newInstance(name, lat, lon),
            tag = MapFragment::class.java.name
        )
    }

    fun onBackPressed() {
        activity.finish()
    }

}