package com.android.presentation.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.presentation.R
import com.android.presentation.common.view.BaseFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


/**
 * Created by hassanalizadeh on 19,October,2020
 */
class MapFragment : BaseFragment(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        setupMap()
    }

    private fun setupMap() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Location and move the camera
        val (name, location) = getLocation() ?: return
        mMap.addMarker(
            MarkerOptions()
                .position(location)
                .title(name)
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 9.0f))
    }

    /**
     * first is the name of the location
     * second is the location of the place
     * */
    private fun getLocation(): Pair<String, LatLng>? {
        val lan = arguments?.getDouble(LAN) ?: return null
        val lon = arguments?.getDouble(LON) ?: return null
        val name = arguments?.getString(NAME) ?: return null

        return name to LatLng(lan, lon)
    }

    companion object {
        private const val NAME = "name"
        private const val LON = "lon"
        private const val LAN = "lan"
        fun newInstance(name: String, lan: Double, lon: Double): MapFragment =
            MapFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME, name)
                    putDouble(LAN, lan)
                    putDouble(LON, lon)
                }
            }
    }

}