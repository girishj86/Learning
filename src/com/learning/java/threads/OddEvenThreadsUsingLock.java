package com.learning.java.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenThreadsUsingLock {
	
	static SharedObject sharedObject;

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition evenCondition = lock.newCondition();
        Condition oddCondition = lock.newCondition();
        sharedObject = new SharedObject("Even", 0, 20);
       
        Thread evenThread = new Thread() {
            @Override
            public void run() {
                while (sharedObject.counter < sharedObject.max) {
                    try {
                        lock.lock();
                        while (sharedObject.state.equals("Odd")) {
                            try {
                                evenCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
						if (sharedObject.counter % 2 == 0) {
							System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
						}
						sharedObject.counter++;
                        sharedObject.state = "Odd";
                        oddCondition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Thread oddThread = new Thread() {
            @Override
            public void run() {
                while (sharedObject.counter < sharedObject.max) {
                    try {
                        lock.lock();
                        while (sharedObject.state.equals("Even")) {
                            try {
                                oddCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
						if (sharedObject.counter % 2 == 1) {
							System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
						}
                        sharedObject.counter++;
                        sharedObject.state = "Even";
                        evenCondition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };
        evenThread.setName("EvenThread");
        evenThread.start();
        oddThread.setName("OddThread");
        oddThread.start();
    }

}
