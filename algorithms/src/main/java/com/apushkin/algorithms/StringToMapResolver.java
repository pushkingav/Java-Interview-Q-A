package com.apushkin.algorithms;

import java.util.*;

/*
* Есть строка, состоящая из слов. Все слова в ней разделены одним пробелом. Нужно преобразовать строку в такую
* структуру данных, которая группирует слова по первой букве в слове. Затем вывести только группы, содержащие более
* одного элемента.

Группы должны быть отсортированы в алфавитном порядке. Слова внутри группы нужно сортировать по убыванию количества
* символов; если количество символов равное, то сортировать в алфавитном порядке.

Пример строки: String s = «сапог сарай арбуз болт бокс биржа»

Отсортированная строка: [б=[биржа, бокс, болт], c=[сапог, сарай]]

Ответ присылайте ссылкой на опубликованный приватный Gist. Комментарии и тесты приветствуются.
*
* */
public class StringToMapResolver {
    private final Comparator<String> customStringComparator =
            Comparator.comparingInt(String::length).reversed().thenComparing(s -> s);

    Map<Character, List<String>> createTemporaryMap(String input) {
        String[] words = input.split(" ");
        Map<Character, List<String>> groups = new TreeMap<>();
        for (String word : words) {
            Character startingChar = word.charAt(0);
            List<String> list = groups.computeIfAbsent(startingChar, (strValue) -> new ArrayList<>());
            list.add(word);
            groups.putIfAbsent(word.charAt(0), list);
        }
        return groups;
    }

    public String composeResult(String input) {
        Map<Character, List<String>> groups = createTemporaryMap(input);

        StringBuilder sb = new StringBuilder("[");
        for (Iterator<Map.Entry<Character, List<String>>> iterator = groups.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Character, List<String>> entry = iterator.next();
            List<String> strings = entry.getValue();
            if (strings.size() <= 1) {
                continue;
            }
            strings.sort(customStringComparator);
            sb.append(entry.getKey()).append("=[");
            strings.forEach(str -> sb.append(str).append(", "));
            sb.delete(sb.length() - 2, sb.length()).append("]"); //убираем ", " в конце группы перед закрывающей скобкой
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Comparator<String> getCustomStringComparator() {
        return customStringComparator;
    }
}
