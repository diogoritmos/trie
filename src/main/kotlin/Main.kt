package br.com.diogoritmos

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val trie = Trie()

    trie.insert("som")
    trie.insert("sol")

    trie.search("s")
}