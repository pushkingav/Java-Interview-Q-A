package com.apushkin.algorithms;

/*
* Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом. Нужно преобразовать строку в такую
* структуру данных, которая группирует слова по первой букве в слове. Затем вывести только группы, содержащие более
* одного элемента.

Группы должны быть отсортированы в алфавитном порядке. Слова внутри группы нужно сортировать по убыванию количества
* символов; если количество символов равное, то сортировать в алфавитном порядке.

Пример строки: String s = «сапог сарай арбуз болт бокс биржа»

Отсортированная строка: [б=[биржа, бокс, болт], c=[caпог, сарай]]

Ответ присылайте ссылкой на опубликованный приватный Gist. Комментарии и тесты приветствуются.
*
* */

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
