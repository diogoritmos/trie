package br.com.diogoritmos

class TrieNode {
    var data: String? = ""
    var isWord: Boolean = false
    val children = mutableMapOf<String, TrieNode>()

    constructor(data: String?, isWord: Boolean) {
        this.data = data
        this.isWord = isWord
    }
}