package com.android.presentation.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.domain.entity.CityObject
import com.android.presentation.R
import com.android.presentation.adapter.BaseAction
import com.android.presentation.common.extension.linearLayout
import com.android.presentation.common.extension.observe
import com.android.presentation.common.extension.viewModelProvider
import com.android.presentation.common.utils.TextWatcherAdapter
import com.android.presentation.common.utils.Utils
import com.android.presentation.common.view.BaseFragment
import com.android.presentation.common.viewmodel.ViewModelProviderFactory
import com.android.presentation.ui.city.adapter.CityAdapter
import com.android.presentation.ui.city.adapter.ViewCityOnMapAction
import kotlinx.android.synthetic.main.fragment_city.*
import javax.inject.Inject

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CityFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: CityViewModel
    private lateinit var adapter: CityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelProvider(factory)
        adapter = CityAdapter(viewModel::clickObserver)

        observe(viewModel.cities, ::observeCities)
        observe(viewModel.clickObserver, ::observeClicks)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_city, container, false)


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        setupRecyclerView()
        setupAdapter()
        setupTextWatcher()

        if (savedInstanceState == null)
            viewModel.filter()
    }

    private fun setupRecyclerView() {
        recyclerView?.linearLayout(
            context = activityContext,
            spacing = Utils.convertPxToDp(activityContext, 8f).toInt()
        )
    }

    private fun setupAdapter() {
        recyclerView?.adapter = adapter
    }

    private fun setupTextWatcher() {
        edtFilter.addTextChangedListener(object : TextWatcherAdapter() {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.filter(s.toString())
            }
        })
    }

    private fun observeCities(cities: List<CityObject>?) {
        cities?.let {
            adapter.addItems(cities.toMutableList())
        }
    }

    private fun observeClicks(action: BaseAction) {
        when (action) {
            is ViewCityOnMapAction -> {
                println("Hassan, Go to map page")
            }
        }
    }

    companion object {
        fun newInstance(): CityFragment = CityFragment()
    }
}