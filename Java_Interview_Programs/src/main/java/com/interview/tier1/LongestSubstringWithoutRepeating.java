package com.interview.tier1;

import java.util.*;
import java.util.stream.IntStream;

public class LongestSubstringWithoutRepeating {

    // Stream approach: readable but not the preferred interview solution.
    public static int streamApproach(String input) {
        if (input == null) return 0;

        return IntStream.range(0, input.length())
                .map(i -> {
                    Set<Character> seen = new HashSet<>();
                    for (int j = i; j < input.length(); j++) {
                        if (!seen.add(input.charAt(j))) return j - i;
                    }
                    return input.length() - i;
                })
                .max()
                .orElse(0);
    }

    // Optimized sliding window: O(n) time, O(k) space.
    public static int optimized(String input) {
        if (input == null || input.isEmpty()) return 0;

        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < input.length(); right++) {
            char c = input.charAt(right);
            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }
            lastSeen.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(streamApproach(input));
        System.out.println(optimized(input));
    }
}
