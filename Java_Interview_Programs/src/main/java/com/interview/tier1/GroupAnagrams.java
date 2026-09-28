package com.interview.tier1;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    // Stream approach: key = sorted characters
    public static List<List<String>> streamApproach(String[] words) {
        if (words == null) return Collections.emptyList();

        return new ArrayList<>(Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        GroupAnagrams::sortedKey,
                        LinkedHashMap::new,
                        Collectors.toList()))
                .values());
    }

    // Optimized approach: character-frequency key.
    // For fixed alphabet, key creation is O(m + alphabet), avoiding sorting.
    public static List<List<String>> optimized(String[] words) {
        if (words == null) return Collections.emptyList();

        Map<String, List<String>> groups = new LinkedHashMap<>();

        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toLowerCase().toCharArray()) {
                if (c >= 'a' && c <= 'z') count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    private static String sortedKey(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(streamApproach(input));
        System.out.println(optimized(input));
    }
}
