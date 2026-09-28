package com.interview.tier3;

import java.util.stream.IntStream;

public class MinimumSizeSubarraySum {
    // Brute-force Stream-compatible approach for comparison: O(n^2).
    public static int stream(int[] nums, int target) {
        int result = IntStream.range(0, nums.length)
                .map(start -> IntStream.range(start, nums.length)
                        .map(end -> { int sum=0; for(int i=start;i<=end;i++) sum+=nums[i]; return sum>=target ? end-start+1 : Integer.MAX_VALUE; })
                        .min().orElse(Integer.MAX_VALUE))
                .min().orElse(Integer.MAX_VALUE);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // Sliding window works because all numbers are positive: O(n), O(1).
    public static int optimized(int[] nums, int target) {
        int left = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        System.out.println(optimized(a, 7));
    }
}
