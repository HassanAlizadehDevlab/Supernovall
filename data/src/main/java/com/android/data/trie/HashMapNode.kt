package com.android.data.trie

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class HashMapNode<T> : Node<T> {
    private var values: MutableList<T>? = null
    private var children: MutableMap<Char, Node<T>>? = null
    private var isEndOfItem: Boolean = false


    override fun addValue(value: T) {
        if (values == null)
            values = mutableListOf()

        values?.add(value)
    }

    override fun getValues(): MutableList<T>? {
        return values
    }

    override fun isEndOfItem(): Boolean {
        return isEndOfItem
    }

    override fun setEndOfItem() {
        isEndOfItem = true
    }

    override fun addChild(nameSpace: Char) {
        if (children == null)
            children = mutableMapOf()

        if (children?.containsKey(nameSpace)?.or(false) == false)
            children?.put(nameSpace, HashMapNode())
    }

    override fun getChild(nameSpace: Char): Node<T>? {
        return children?.get(nameSpace)
    }

    override fun hasChild(nameSpace: Char): Boolean {
        return children?.containsKey(nameSpace) ?: false
    }

    override fun getChildren(): MutableList<Node<T>> {
        return children?.values?.toMutableList() ?: mutableListOf()
    }

}