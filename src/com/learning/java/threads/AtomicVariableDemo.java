package com.learning.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo
{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(25);

        AtomicInteger atomicCounter = new AtomicInteger ();
        Counter counter = new Counter();

        for(int i = 0; i < 100; i++) {
            executorService.submit(() -> atomicCounter.incrementAndGet());
        }

        for(int i = 0; i < 100; i++) {
            executorService.submit(() -> counter.increment());
        }

        executorService.shutdown();
        executorService.awaitTermination(60, TimeUnit.SECONDS);

        System.out.println("Final Atomic Count is : " + atomicCounter.get());
        System.out.println("Final Count is : " + counter.count);
    }
}

class Counter {
    int count = 0;

    public void increment(){
        count++;
    }
}