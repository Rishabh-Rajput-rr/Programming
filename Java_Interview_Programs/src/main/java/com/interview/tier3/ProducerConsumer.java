package com.interview.tier3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    // Preferred modern Java approach: BlockingQueue handles waiting, visibility and coordination.
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        int poison = -1;

        Thread producer = new Thread(() -> {
            try {
                for (int i=1;i<=10;i++) { queue.put(i); System.out.println("Produced: "+i); }
                queue.put(poison);
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) { int value=queue.take(); if(value==poison)break; System.out.println("Consumed: "+value); }
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        producer.start(); consumer.start(); producer.join(); consumer.join();
    }
}
