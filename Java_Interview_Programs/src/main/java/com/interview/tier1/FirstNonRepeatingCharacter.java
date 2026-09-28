package com.interview.tier1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {

    // Java 8 Streams: O(n) time, O(k) space
    public static Optional<Character> streamApproach(String input) {
        if (input == null || input.isEmpty()) return Optional.empty();

        Map<Character, Long> frequency = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        return frequency.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }

    // Optimized interview approach: two passes, O(n) time, O(k) space
    public static Optional<Character> optimized(String input) {
        if (input == null || input.isEmpty()) return Optional.empty();

        int[] count = new int[Character.MAX_VALUE + 1];
        for (char c : input.toCharArray()) count[c]++;
        for (char c : input.toCharArray()) {
            if (count[c] == 1) return Optional.of(c);
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        String input = "Swiss";
        System.out.println(streamApproach(input).orElse(null));
        System.out.println(optimized(input).orElse(null));
    }
}
