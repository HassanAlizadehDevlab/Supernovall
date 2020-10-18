package com.android.data.trie

/**
 * Created by hassanalizadeh on 18,October,2020
 */
interface Node<T> {
    fun values(): MutableList<T>?
    fun setEndOfItem(): Boolean
    fun isEndOfItem(): Boolean
    fun addChild(nameSpace: Char)
    fun getChild(nameSpace: Char): Node<T>?
    fun hasChild(nameSpace: Char): Boolean
    fun getChildren(): MutableList<Node<T>>
}