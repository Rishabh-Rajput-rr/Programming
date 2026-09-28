package com.interview.tier3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RotateArray {
    public static int[] stream(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return nums;
        k = ((k % n) + n) % n;
        final int steps = k;
        return IntStream.range(0, n).map(i -> nums[(i - steps + n) % n]).toArray();
    }

    // Reversal algorithm: O(n) time, O(1) extra space.
    public static void optimized(int[] nums, int k) {
        if (nums.length == 0) return;
        k = ((k % nums.length) + nums.length) % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) { int t = a[l]; a[l++] = a[r]; a[r--] = t; }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(stream(a, 3)));
        optimized(a, 3);
        System.out.println(Arrays.toString(a));
    }
}
