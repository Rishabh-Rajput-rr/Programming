package com.interview.tier3;

import java.util.Arrays;

public class MissingNumber {
    // Stream/math approach: expected sum - actual sum.
    public static int stream(int[] nums) {
        int n = nums.length + 1;
        long expected = (long) n * (n + 1) / 2;
        long actual = Arrays.stream(nums).asLongStream().sum();
        return (int) (expected - actual);
    }

    // XOR avoids arithmetic overflow and uses O(1) extra space.
    public static int optimized(int[] nums) {
        int n = nums.length + 1;
        int xor = 0;
        for (int i = 1; i <= n; i++) xor ^= i;
        for (int x : nums) xor ^= x;
        return xor;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 5, 6};
        System.out.println(stream(input));
        System.out.println(optimized(input));
    }
}
