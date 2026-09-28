package com.interview.tier2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductExceptSelf {
 public static int[] stream(int[] a){return IntStream.range(0,a.length).map(i->{int p=1;for(int j=0;j<a.length;j++)if(i!=j)p*=a[j];return p;}).toArray();}
 public static int[] optimized(int[] a){int[] r=new int[a.length];int p=1;for(int i=0;i<a.length;i++){r[i]=p;p*=a[i];}p=1;for(int i=a.length-1;i>=0;i--){r[i]*=p;p*=a[i];}return r;}
 public static void main(String[] args){int[] a={1,2,3,4};System.out.println(Arrays.toString(stream(a)));System.out.println(Arrays.toString(optimized(a)));}
}
