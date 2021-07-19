package com.learning.dsa.trie;

public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("he");
        trie.insert("hell");
        trie.insert("good");
        trie.insert("go");
        trie.insert("get");
        trie.searchWord("h");
        trie.searchWord("he");
        trie.searchWord("hel");
        trie.searchWord("hell");
        trie.searchWord("hello");
        trie.searchWord("good");
        trie.searchWord("go");
        trie.searchWord("ge");
        trie.searchWord("get");
        trie.suggestions("g").forEach(System.out::println);
      }
}
