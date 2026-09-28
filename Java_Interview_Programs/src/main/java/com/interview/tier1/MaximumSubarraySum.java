package com.interview.tier1;

import java.util.Arrays;

public class MaximumSubarraySum {

    // Stream approach using all contiguous ranges. O(n^2) time.
    public static int streamApproach(int[] numbers) {
        return Arrays.stream(numbers)
                .reduce((a, b) -> Math.max(a + b, b))
                .orElse(0);
    }

    // Kadane's algorithm: O(n) time, O(1) extra space.
    public static int optimized(int[] numbers) {
        if (numbers == null || numbers.length == 0) return 0;

        int current = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            current = Math.max(numbers[i], current + numbers[i]);
            max = Math.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(streamApproach(input));
        System.out.println(optimized(input));
    }
}
