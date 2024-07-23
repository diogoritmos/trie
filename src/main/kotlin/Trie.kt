package br.com.diogoritmos

class Trie {
    val root = TrieNode(null, false)

    fun insert(word: String) {
        var previous = root

        for (i in 0..word.length-1) {
            val character = word.get(i).toString()
            var current = previous.children.get(character)

            val isLast = i == (word.length - 1)
            if (current == null) {
                current = TrieNode(character, isLast)
                previous.children.put(character, current)
            }

            if (isLast) {
                current.isWord = true
            }

            previous = current
        }
    }
}