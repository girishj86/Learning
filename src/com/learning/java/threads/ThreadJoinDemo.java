package com.learning.java.threads;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" has started");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" has finished");
            }
        };

        Thread t1 = new Thread(task);
        t1.setName("Thread1");
        t1.start();
        t1.join();
        Thread t2 = new Thread(task);
        t2.setName("Thread2");
        t2.start();
        t2.join();
        Thread t3 = new Thread(task);
        t3.setName("Thread3");
        t3.start();
        t3.join();
        System.out.println("Main Thread completed");


    }
}

