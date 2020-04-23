package com.apushkin.algorithms;

public class TrieTest {
    public static void main(String[] args) {
        String input = "сапог сарай арбуз болт бокс биржа";
        String[] words = input.split(" ");

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        System.out.println("Done");
    }
}
