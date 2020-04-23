package com.apushkin.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private char c;
    private Map<Character, TrieNode> children = new HashMap<>();
    private boolean isLeaf;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }

    public char getChar() {
        return c;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }
}
