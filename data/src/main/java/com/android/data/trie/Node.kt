package com.android.data.trie

/**
 * Created by hassanalizadeh on 18,October,2020
 */
interface Node<T> {
    fun setEndOfItem()
    fun isEndOfItem(): Boolean
    fun hasChild(nameSpace: Char): Boolean
    fun addValue(value: T)
    fun addChild(nameSpace: Char)
    fun getChild(nameSpace: Char): Node<T>?
    fun getValues(): MutableList<T>?
    fun getChildren(): MutableList<Node<T>>
}