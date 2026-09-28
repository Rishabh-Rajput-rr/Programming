package com.interview.tier2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {public static boolean stream(String s){return optimized(s);}public static boolean optimized(String s){if(s==null||s.length()%2!=0)return false;Deque<Character>d=new ArrayDeque<>();for(char c:s.toCharArray()){if(c=='('||c=='{'||c=='[')d.push(c);else if(c==')'||c=='}'||c==']'){if(d.isEmpty()||!match(d.pop(),c))return false;}else return false;}return d.isEmpty();}static boolean match(char a,char b){return a=='('&&b==')'||a=='{'&&b=='}'||a=='['&&b==']';}public static void main(String[] args){System.out.println(optimized("()[]{}"));System.out.println(optimized("([)]"));}}
