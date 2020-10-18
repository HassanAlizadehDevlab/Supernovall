package com.android.data.trie

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class Trie<T> {
    private val root: Node<T> = HashMapNode()

    fun insert(value: T, name: () -> String) {
        var current = root

        for (ch in name.invoke()) {
            current.addChild(ch)
            current = current.getChild(ch) ?: break
        }
        current.addValue(value)
        current.setEndOfItem()
    }
}