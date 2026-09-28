package com.interview.tier2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {
    public static int[] stream(int[] a, int target) {
        return IntStream.range(0, a.length).boxed().flatMap(i -> IntStream.range(i + 1, a.length).filter(j -> a[i] + a[j] == target).mapToObj(j -> new int[]{i, j})).findFirst().orElse(new int[0]);
    }

    public static int[] optimized(int[] a, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int c = target - a[i];
            if (m.containsKey(c)) return new int[]{m.get(c), i};
            m.put(a[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        System.out.println(Arrays.toString(stream(a, 9)));
        System.out.println(Arrays.toString(optimized(a, 9)));
    }
}
