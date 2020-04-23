package com.apushkin.algorithms;

import java.util.Map;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.getChildren();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            TrieNode node;
            if (children.containsKey(ch)) {
                node = children.get(ch);
            } else {
                node = new TrieNode(ch);
                children.put(ch, node);
            }

            children = node.getChildren();

            if (i == word.length() - 1) {
                node.setLeaf(true);
            }
        }
    }
}
