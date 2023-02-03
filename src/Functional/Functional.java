package Functional;

import java.util.*;

import static java.util.Collections.sort;

// Задача на функциональное программирование
public class Functional {
    public static void main(String[] args) {
        System.out.println("Введите текст:");
        Map<String, Integer> occurrences = new LinkedHashMap<>();
        List<String> arrayText;
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        arrayText = Arrays.asList(text.split(" "));
        sort(arrayText);
        System.out.println("В тексте " + (arrayText.size()) + " слов");
        for (int i = 0; i <= arrayText.size() - 1; i++) {
            Integer oldCount = occurrences.get(arrayText.get(i));
            if (oldCount == null) {
                oldCount = 0;
            }
            occurrences.put(arrayText.get(i), oldCount + 1);
        }
        List<Map.Entry<String, Integer>> word = new LinkedList(occurrences.entrySet());
        word.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (Map.Entry<String, Integer> words : word) {
            System.out.println(words.getValue() + " — " + words.getKey());
        }
    }
}




