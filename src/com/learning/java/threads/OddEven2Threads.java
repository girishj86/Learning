package com.learning.java.threads;

public class OddEven2Threads {

	public static void main(String[] args) {
		SharedObject sharedObject = new SharedObject("Even", 0, 20);
		Thread threadEven = new ThreadEven(sharedObject);
		Thread threadOdd = new ThreadOdd(sharedObject);
		threadEven.setName("EvenThread");
		threadEven.start();
		threadOdd.setName("OddThread");
		threadOdd.start();
	}
}

class ThreadEven extends Thread {

	SharedObject sharedObject;

	public ThreadEven(SharedObject sharedObject) {
		this.sharedObject = sharedObject;
	}

	@Override
	public void run() {
		while (sharedObject.counter < sharedObject.max) {
			synchronized (sharedObject) {
				while (sharedObject.status.equals("Odd")) {
					try {
						sharedObject.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (sharedObject.counter % 2 == 0) {
					System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
				}
				sharedObject.counter++;
				sharedObject.status = "Odd";
				sharedObject.notifyAll();

			}
		}
	}
}

class ThreadOdd extends Thread {

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
					try {
						sharedObject.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				if (sharedObject.counter % 2 == 1) {
					System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
				}
				sharedObject.counter++;
				sharedObject.status = "Even";
				sharedObject.notifyAll();
			}
		}
	}
}
