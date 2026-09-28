package com.interview.tier3;

import java.util.Arrays;

public class DutchNationalFlag {
    public static int[] stream(int[] nums) {
        return Arrays.stream(nums).sorted().toArray();
    }

    // DNF: low/mid/high, O(n) time, O(1) space.
    public static void optimized(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) swap(nums, low++, mid++);
            else if (nums[mid] == 1) mid++;
            else if (nums[mid] == 2) swap(nums, mid, high--);
            else throw new IllegalArgumentException("Only 0, 1 and 2 are allowed");
        }
    }

    private static void swap(int[] a, int i, int j) { int t=a[i];a[i]=a[j];a[j]=t; }

    public static void main(String[] args) {
        int[] a={2,0,2,1,1,0}; optimized(a); System.out.println(Arrays.toString(a));
    }
}
