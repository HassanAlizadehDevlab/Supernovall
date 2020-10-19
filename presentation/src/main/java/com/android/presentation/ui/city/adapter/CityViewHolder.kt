package com.android.presentation.ui.city.adapter

import android.view.View
import com.android.domain.entity.CityObject
import com.android.domain.entity.DomainObject
import com.android.presentation.adapter.BaseViewHolder
import kotlinx.android.synthetic.main.adapter_city.view.*

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CityViewHolder(
    private val view: View
) : BaseViewHolder<CityObject>(view) {

    override fun bind(data: DomainObject?) {
        data ?: return
        if (data !is CityObject) return

        "${data.name}, ${data.country}".let {
            view.txtName.text = it
        }

        view.root.setOnClickListener { listener.invoke(ViewCityOnMapAction(data)) }
    }

}