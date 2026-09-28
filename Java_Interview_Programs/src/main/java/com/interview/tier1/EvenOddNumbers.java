package com.interview.tier1;

import java.util.*;
import java.util.stream.Collectors;

public class EvenOddNumbers {

    // Stream approach: partitioningBy
    public static Map<Boolean, List<Integer>> streamApproach(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
    }

    // Optimized one-pass approach: O(n) time, O(n) output space
    public static Map<Boolean, List<Integer>> optimized(List<Integer> numbers) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (Integer n : numbers) {
            if (n % 2 == 0) even.add(n);
            else odd.add(n);
        }

        Map<Boolean, List<Integer>> result = new HashMap<>();
        result.put(true, even);
        result.put(false, odd);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(streamApproach(numbers));
        System.out.println(optimized(numbers));
    }
}
