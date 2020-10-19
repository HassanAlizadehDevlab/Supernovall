package com.android.presentation.ui.city.adapter

import android.view.ViewGroup
import com.android.domain.entity.DomainObject
import com.android.presentation.adapter.*
import com.android.presentation.common.extension.inflate

/**
 * Created by hassanalizadeh on 19,October,2020
 */
class CityAdapter(
    private val listener: (BaseAction) -> Unit
) : BaseRecyclerAdapter() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<out DomainObject> {
        val view = parent.inflate(viewType)
        val holder = when (viewType) {
            ViewTypeHolder.CITY_VIEW -> CityViewHolder(view)
            else -> EmptyViewHolder(view)
        }
        holder.listener = listener
        return holder
    }

}