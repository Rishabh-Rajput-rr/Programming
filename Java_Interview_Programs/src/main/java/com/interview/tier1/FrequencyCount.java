package com.interview.tier1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyCount {

    // Character frequency using groupingBy + counting
    public static Map<Character, Long> characterFrequency(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
    }

    // Word frequency
    public static Map<String, Long> wordFrequency(String input) {
        return Arrays.stream(input.toLowerCase().trim().split("\\s+"))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
    }

    // Optimized character frequency: one pass.
    public static Map<Character, Integer> optimizedCharacterFrequency(String input) {
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(characterFrequency("banana"));
        System.out.println(wordFrequency("java spring java stream"));
        System.out.println(optimizedCharacterFrequency("banana"));
    }
}
