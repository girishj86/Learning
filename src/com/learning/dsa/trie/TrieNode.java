package com.learning.dsa.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private char c;
    private Map<Character,TrieNode> children;
    private boolean isLeaf;

    public TrieNode(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }

    public char getChar() {
        return c;
    }

    public void setChar(char c) {
        this.c = c;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "c=" + c +
                ", children=" + children +
                ", isLeaf=" + isLeaf +
                '}';
    }
}
