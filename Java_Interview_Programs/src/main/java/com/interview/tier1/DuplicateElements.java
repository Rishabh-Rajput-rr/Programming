package com.interview.tier1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElements {

    // Stream approach. A frequency map is the safest general solution.
    public static List<Integer> streamApproach(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Optimized: HashSet gives average O(n) time and O(n) space.
    public static List<Integer> optimized(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new LinkedHashSet<>();

        for (Integer n : numbers) {
            if (!seen.add(n)) duplicates.add(n);
        }
        return new ArrayList<>(duplicates);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 2);
        System.out.println(streamApproach(numbers));
        System.out.println(optimized(numbers));
    }
}
