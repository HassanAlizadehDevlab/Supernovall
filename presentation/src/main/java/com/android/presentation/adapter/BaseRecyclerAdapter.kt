package com.android.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.android.domain.entity.DomainObject

/**
 * Created by hassanalizadeh on 18,February,2019
 */
abstract class BaseRecyclerAdapter() : RecyclerView.Adapter<BaseViewHolder<out DomainObject>>(),
    IRecyclerAdapter {

    protected var mItems: MutableList<DomainObject> = mutableListOf()


    override fun getItemViewType(position: Int): Int {
        return ViewTypeHolder.getView(mItems[position])
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<out DomainObject>, position: Int) {
        holder.bind(mItems[position])
    }

    override fun <T : DomainObject> addItem(index: Int, item: T) {
        this.mItems.add(index, item)
        notifyItemInserted(index)
    }

    override fun <T : DomainObject> addItem(item: T) {
        this.mItems.add(item)
        notifyItemInserted(mItems.size - 1)
    }

    override fun <T : DomainObject> addItems(items: MutableList<T>) {
        removeAll()
        this.mItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun addItemsList(items: List<*>) {
        removeAll()
        items.forEach {
            if (it is DomainObject)
                this.mItems.add(it)
        }
        notifyDataSetChanged()
    }

    override fun <T : DomainObject> addItemsWithoutClear(items: MutableList<T>) {
        this.mItems.addAll(items)
        notifyDataSetChanged()
    }

    override fun remove(index: Int) {
        if (mItems.size > 0) {
            mItems.removeAt(index)
            notifyItemRemoved(index)
        }
    }

    override fun removeAll() {
        mItems.clear()
    }

}