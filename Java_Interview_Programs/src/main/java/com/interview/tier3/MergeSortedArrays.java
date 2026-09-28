package com.interview.tier3;

import java.util.Arrays;

public class MergeSortedArrays {
    // Standard merge into a new array: O(n+m) time, O(n+m) space.
    public static int[] stream(int[] a, int[] b) {
        return java.util.stream.IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
    }

    // In-place merge without a third array. Uses Shell-gap method: O((n+m) log(n+m)).
    public static void optimized(int[] a, int[] b) {
        int total = a.length + b.length;
        for (int gap = nextGap(total); gap > 0; gap = nextGap(gap)) {
            for (int i=0;i+gap<total;i++) {
                int j=i+gap;
                int x=get(a,b,i), y=get(a,b,j);
                if(x>y){set(a,b,i,y);set(a,b,j,x);}
            }
        }
    }
    private static int nextGap(int gap){ if(gap<=1)return 0; return (gap+1)/2; }
    private static int get(int[] a,int[] b,int i){return i<a.length?a[i]:b[i-a.length];}
    private static void set(int[] a,int[] b,int i,int v){if(i<a.length)a[i]=v;else b[i-a.length]=v;}

    public static void main(String[] args){int[]a={1,4,7,8};int[]b={2,3,6,9};optimized(a,b);System.out.println(Arrays.toString(a));System.out.println(Arrays.toString(b));}
}
