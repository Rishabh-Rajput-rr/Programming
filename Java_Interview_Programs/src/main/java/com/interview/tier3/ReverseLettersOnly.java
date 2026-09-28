package com.interview.tier3;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseLettersOnly {
 public static String stream(String s){List<Character> l=s.chars().mapToObj(c->(char)c).filter(Character::isLetter).collect(Collectors.toList());Collections.reverse(l);StringBuilder r=new StringBuilder();int i=0;for(char c:s.toCharArray())r.append(Character.isLetter(c)?l.get(i++):c);return r.toString();}
 public static String optimized(String s){char[] a=s.toCharArray();int l=0,r=a.length-1;while(l<r){if(!Character.isLetter(a[l]))l++;else if(!Character.isLetter(a[r]))r--;else{char t=a[l];a[l++]=a[r];a[r--]=t;}}return new String(a);}
 public static void main(String[] args){String s="a1b2c3d4e5f";System.out.println(stream(s));System.out.println(optimized(s));}
}
