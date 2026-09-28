package com.interview.tier3;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElement {
    // Brute-force/Stream-compatible baseline: O(n^2).
    public static int[] stream(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i=0;i<nums.length;i++) for(int j=i+1;j<nums.length;j++) if(nums[j]>nums[i]){result[i]=nums[j];break;}
        return result;
    }

    // Monotonic decreasing stack: O(n) time, O(n) space.
    public static int[] optimized(int[] nums) {
        int[] result = new int[nums.length]; Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<nums.length;i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) result[stack.pop()] = nums[i];
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) { System.out.println(Arrays.toString(optimized(new int[]{4,5,2,10,8}))); }
}
