package com.interview.tier3;

public class DetectCycleLinkedList {
    static class Node { int data; Node next; Node(int d){data=d;} }

    // Floyd's tortoise and hare: O(n) time, O(1) space.
    public static boolean hasCycle(Node head) {
        Node slow=head, fast=head;
        while(fast!=null && fast.next!=null){slow=slow.next;fast=fast.next.next;if(slow==fast)return true;}
        return false;
    }

    public static void main(String[] args){Node a=new Node(1),b=new Node(2),c=new Node(3);a.next=b;b.next=c;c.next=a;System.out.println(hasCycle(a));}
}
