package com.interview.tier3;

public class StringRotationCheck {
    public static boolean stream(String a, String b) {
        return a != null && b != null && a.length() == b.length()
                && (a + a).contains(b);
    }

    public static boolean optimized(String a, String b) {
        return a != null && b != null && a.length() == b.length()
                && (a + a).indexOf(b) >= 0;
    }

    public static void main(String[] args) {
        System.out.println(optimized("abcd", "cdab"));
        System.out.println(optimized("abcd", "acbd"));
    }
}
