package com.learning.dsa.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode('-');
    }

    public void insert(String word) {
        if (word == null || word.trim().isBlank()) {
            return;
        }
        TrieNode node = this.root;
        Map<Character, TrieNode> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();
        }
        node.setLeaf(true);
    }

    public boolean search(String word) {
        if (word == null || word.trim().isBlank()) {
            return false;
        }
        TrieNode node = this.root;
        Map<Character, TrieNode> children = root.getChildren();
        for (char c : word.toCharArray()) {
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                return false;
            }
            children = node.getChildren();
        }
        return node.isLeaf();
    }

    public void searchWord(String word) {
        System.out.println(this.search(word) ? word + " exists" : word + " doesn't exist");
    }

    private void suggestionHelper(TrieNode node, List<String> suggestions, StringBuilder buffer) {
        if (node.isLeaf()) {
            suggestions.add(buffer.toString());
        }

        if (node.getChildren() == null || node.getChildren().isEmpty())
            return;

        for (TrieNode child : node.getChildren().values()) {
            suggestionHelper(child, suggestions, buffer.append(child.getChar()));
            buffer.setLength(buffer.length() - 1);
        }
    }

    public List<String> suggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        TrieNode node = root;
        StringBuilder buffer = new StringBuilder();
        for (char c : prefix.toCharArray()) {
            node = node.getChildren().get(c);
            if (node == null) {
                return suggestions;
            }
            buffer.append(c);
        }
        suggestionHelper(node, suggestions, buffer);
        return suggestions;
    }


}
