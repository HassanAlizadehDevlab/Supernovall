package com.android.data.trie

/**
 * Created by hassanalizadeh on 18,October,2020
 */
class Trie<T> {
    private val root: Node<T> = HashMapNode()

    fun insert(value: T, name: String) {
        var current = root

        for (ch in name) {
            current.addChild(ch)
            current = current.getChild(ch) ?: break
        }
        current.addValue(value)
        current.setEndOfItem()
    }

    fun findWords(prefix: String): List<T>? {
        if (prefix.isEmpty()) return null
        val lastNode = findLastNodeOf(prefix) ?: return null

        val words = mutableListOf<T>()
        findWords(lastNode, words)
        return words
    }

    private fun findWords(root: Node<T>, words: MutableList<T>) {
        if (root.isEndOfItem() && !root.getValues().isNullOrEmpty())
            root.getValues()?.forEach { words.add(it) }

        for (child in root.getChildren())
            findWords(child, words)
    }

    private fun findLastNodeOf(prefix: String): Node<T>? {
        var current = root
        for (ch in prefix) {
            current = current.getChild(ch) ?: return null
        }

        return current
    }

    public fun hasNode(): Boolean {
        return root.getChildren().isNullOrEmpty().not()
    }

}