package com.interview.tier2;
public class MaximumProductSubarray {
 public static int stream(int[] a){int max=Integer.MIN_VALUE;for(int i=0;i<a.length;i++){int p=1;for(int j=i;j<a.length;j++){p*=a[j];max=Math.max(max,p);}}return max;}
 public static int optimized(int[] a){if(a==null||a.length==0)return 0;int mx=a[0],mn=a[0],ans=a[0];for(int i=1;i<a.length;i++){if(a[i]<0){int t=mx;mx=mn;mn=t;}mx=Math.max(a[i],mx*a[i]);mn=Math.min(a[i],mn*a[i]);ans=Math.max(ans,mx);}return ans;}
 public static void main(String[] args){int[] a={2,3,-2,4};System.out.println(stream(a));System.out.println(optimized(a));}
}
