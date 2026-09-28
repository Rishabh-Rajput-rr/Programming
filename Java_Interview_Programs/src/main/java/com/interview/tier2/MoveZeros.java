package com.interview.tier2;

import java.util.Arrays;

public class MoveZeros {
 public static int[] stream(int[] a){int[] n=Arrays.stream(a).filter(x->x!=0).toArray();int[] r=Arrays.copyOf(n,a.length);return r;}
 public static void optimized(int[] a){int w=0;for(int x:a)if(x!=0)a[w++]=x;while(w<a.length)a[w++]=0;}
 public static void main(String[] args){int[] a={2,3,0,1,0,1,2,0,6};System.out.println(Arrays.toString(stream(a)));optimized(a);System.out.println(Arrays.toString(a));}
}
