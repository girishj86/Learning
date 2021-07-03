package com.learning.java.threads;

public class OddEvenPrime3Threads {

	public static void main(String[] args) {
		SharedObject sharedObject = new SharedObject("Even", 0, 20);
		Thread threadEven = new Thread(() -> {
			while (sharedObject.counter < sharedObject.max) {
				synchronized (sharedObject) {
					while (!sharedObject.state.equals("Even")) {
						try {
							sharedObject.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (sharedObject.isEven()) {
						System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
					}
					sharedObject.state = "Odd";
					sharedObject.notifyAll();
				}
			}
		});

		Thread threadOdd = new Thread(() -> {
			while (sharedObject.counter < sharedObject.max) {
				synchronized (sharedObject) {
					while (!sharedObject.state.equals("Odd")) {
						try {
							sharedObject.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (sharedObject.isOdd()) {
						System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
					}
					sharedObject.state = "Prime";
					sharedObject.notifyAll();
				}
			}
		});

		Thread threadPrime = new Thread(() -> {
			while (sharedObject.counter < sharedObject.max) {
				synchronized (sharedObject) {
					while (!sharedObject.state.equals("Prime")) {
						try {
							sharedObject.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if (sharedObject.isPrime()) {
						System.out.println(sharedObject.counter + " printed by " + Thread.currentThread().getName());
					}
					sharedObject.state = "Even";
					sharedObject.notifyAll();
					System.out.println();
					sharedObject.counter++;
				}
			}
		});

		threadEven.setName("Even Thread");
		threadEven.start();
		threadOdd.setName("Odd Thread");
		threadOdd.start();
		threadPrime.setName("Prime Thread");
		threadPrime.start();
	}

}
