<<<<<<< Updated upstream:Practice/Practice/src/com/learning/threads/OddEven2Threads.java
public class OddEven2Threads {

    public static void main(String[] args) {
        LockObject lock = new LockObject("even");
        Thread threadEven = new ThreadEven(lock);
        Thread threadOdd = new ThreadOdd(lock);
=======
package com.learning.threads;

public class OddEven2Threads {

    public static void main(String[] args) {
    	SharedObject sharedObject = new SharedObject("Even", 0, 20);
        Thread threadEven = new ThreadEven(sharedObject);
        Thread threadOdd = new ThreadOdd(sharedObject);
>>>>>>> Stashed changes:Practice/src/com/learning/threads/OddEven2Threads.java
        threadEven.setName("EvenThread");
        threadEven.start();
        threadOdd.setName("OddThread");
        threadOdd.start();
    }
}

class LockObject {
    String condition;
    public LockObject(String condition) {
        this.condition = condition;
    }
}

class ThreadEven extends Thread {
<<<<<<< Updated upstream:Practice/Practice/src/com/learning/threads/OddEven2Threads.java
    int counter = 0;
    LockObject lock;
    ThreadEven(LockObject lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (counter <= 20) {
            synchronized (lock) {
                while (lock.condition.equals("Odd")) {
=======

	SharedObject sharedObject;
	
    public ThreadEven(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
    public void run() {
        while (sharedObject.counter < sharedObject.max) {
            synchronized (sharedObject) {
                while (sharedObject.status.equals("Odd")) {
>>>>>>> Stashed changes:Practice/src/com/learning/threads/OddEven2Threads.java
                    try {
                    	sharedObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
<<<<<<< Updated upstream:Practice/Practice/src/com/learning/threads/OddEven2Threads.java
                System.out.println(counter + " printed by " + Thread.currentThread().getName());
                counter = counter + 2;
                lock.condition = "Odd";
                lock.notifyAll();
=======
				if (sharedObject.counter % 2 == 0) {
					System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
				}
                sharedObject.counter++;
                sharedObject.status = "Odd";
                sharedObject.notifyAll();
>>>>>>> Stashed changes:Practice/src/com/learning/threads/OddEven2Threads.java
            }
        }
    }
}

class ThreadOdd extends Thread {
<<<<<<< Updated upstream:Practice/Practice/src/com/learning/threads/OddEven2Threads.java
    int counter = 1;
    LockObject lock;
    ThreadOdd(LockObject lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        while (counter <= 20) {
            synchronized (lock) {
                while (lock.condition.equals("Even")) {
=======
	SharedObject sharedObject;
	
    public ThreadOdd(SharedObject sharedObject) {
		super();
		this.sharedObject = sharedObject;
	}

	@Override
    public void run() {
        while (sharedObject.counter < sharedObject.max) {
            synchronized (sharedObject) {
                while (sharedObject.status.equals("Even")) {
>>>>>>> Stashed changes:Practice/src/com/learning/threads/OddEven2Threads.java
                    try {
                    	sharedObject.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
<<<<<<< Updated upstream:Practice/Practice/src/com/learning/threads/OddEven2Threads.java
                System.out.println(counter + " printed by " + Thread.currentThread().getName());
                counter = counter + 2;
                lock.condition = "Even";
                lock.notifyAll();
=======
                if (sharedObject.counter % 2 == 1) {
					System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
				}
                sharedObject.counter++;
                sharedObject.status = "Even";
                sharedObject.notifyAll();
>>>>>>> Stashed changes:Practice/src/com/learning/threads/OddEven2Threads.java
            }
        }
    }
}
