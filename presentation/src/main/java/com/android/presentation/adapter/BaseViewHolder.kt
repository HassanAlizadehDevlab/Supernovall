package com.android.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.android.domain.entity.DomainObject


/**
 * Created by hassanalizadeh on 18,February,2019
 */
abstract class BaseViewHolder<T : DomainObject>(view: View) : RecyclerView.ViewHolder(view) {

//    protected val mSubject = PublishSubject.create<BaseAction>()

    abstract fun getType(): Int

    abstract fun bind(data: DomainObject?)

}