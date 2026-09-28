package com.interview.tier2;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueues<T>{private final Queue<T> q=new ArrayDeque<>();public void push(T x){int n=q.size();q.offer(x);while(n-->0)q.offer(q.poll());}public T pop(){if(q.isEmpty())throw new IllegalStateException("Stack is empty");return q.poll();}public T top(){if(q.isEmpty())throw new IllegalStateException("Stack is empty");return q.peek();}public boolean empty(){return q.isEmpty();}public static void main(String[] args){StackUsingQueues<Integer>s=new StackUsingQueues<>();s.push(10);s.push(20);s.push(30);System.out.println(s.top());System.out.println(s.pop());}}
