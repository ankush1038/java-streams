package com.bridgelabz.streams.MostFrequent;

import java.io.*;
import java.util.*;

public class MostFrequentOccurring {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "src/main/java/com/bridgelabz/streams/MostFrequent/input";
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read file line by line
            while ((line = br.readLine()) != null) {
                // Split line into words and count occurrences
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort words by frequency and display top 5 most frequent words
            map.entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .limit(5)
                    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        } catch (IOException e) {
            // Handle file read exceptions
            System.out.println("Error: " + e.getMessage());
        }
    }
}

