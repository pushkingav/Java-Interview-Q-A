package com.apushkin.algorithms;



import java.util.*;

public class TrieTest {
    public static void main(String[] args) {
        String input = "сапог сарай арбуз болт бокс биржа";
        String[] words = input.split(" ");

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Map<Character, Set<String>> groups = new TreeMap<>();
        for (String word : words) {
            Character startingChar = word.charAt(0);
            Set<String> set = groups.computeIfAbsent(startingChar, (strValue) -> new TreeSet<>());
            set.add(word);
            groups.putIfAbsent(word.charAt(0), set);
        }

        StringBuilder sb = new StringBuilder("[");
        for (Iterator<Map.Entry<Character, Set<String>>> iterator = groups.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Character, Set<String>> entry = iterator.next();
            Set<String> strings = entry.getValue();
            if (strings.size() <= 1) {
                continue;
            }
            sb.append(entry.getKey()).append("=[");
            strings.forEach(str -> sb.append(str).append(", "));
            sb.delete(sb.length() - 2, sb.length()).append("]"); //убираем ", " в конце группы перед закрывающей скобкой
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb.toString());
    }
}
