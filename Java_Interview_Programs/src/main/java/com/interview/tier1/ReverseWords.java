package com.interview.tier1;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseWords {

    // Reverse characters inside each word, preserve word order.
    public static String reverseEachWordStream(String sentence) {
        if (sentence == null || sentence.isEmpty()) return sentence;

        return Arrays.stream(sentence.split(" ", -1))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    // Optimized: one pass over characters, O(n) time.
    public static String reverseEachWordOptimized(String sentence) {
        if (sentence == null || sentence.isEmpty()) return sentence;

        char[] chars = sentence.toCharArray();
        int start = 0;

        for (int i = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    // Reverse complete word order.
    public static String reverseWordOrder(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return sentence;

        List<String> words = Arrays.asList(sentence.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    public static void main(String[] args) {
        String input = "Hello world";
        System.out.println(reverseEachWordStream(input));
        System.out.println(reverseEachWordOptimized(input));
        System.out.println(reverseWordOrder(input));
    }
}
