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

    fun search(prefix: String): List<String> {
        val results = emptyList<String>().toMutableList()

        val prefixLastNode = navigatePrefix(prefix)

        if (prefixLastNode == null) {
            return results
        }

        addResultNodes(prefix.dropLast(1), prefixLastNode, results)

        return results
    }

    private fun navigatePrefix(prefix: String): TrieNode? {
        var current: TrieNode? = root;

        for (i in 0..prefix.length-1) {
            val character = prefix.get(i).toString()
            current = current?.children?.get(character)

            if (current == null) {
                return null
            }
        }

        return current
    }

    private fun addResultNodes(word: String, currentNode: TrieNode, results: MutableList<String>) {
        val updatedWord = word + currentNode.data

        if (currentNode.isWord) {
            results.add(updatedWord)
        }

        currentNode.children.forEach { _, node -> addResultNodes(updatedWord, node, results) }
    }
}