package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    public static Map<String, Integer> calculatedWord(String text) {
        String cleanedText = text.replaceAll("[^a-zA-Z0-9\\s]", " ");
        String[] words = cleanedText.split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                String lowerCaseWord = word.toLowerCase();
                wordCounts.put(lowerCaseWord, wordCounts.getOrDefault(lowerCaseWord, 0) + 1);
            }
        }
        return wordCounts;
    }
}