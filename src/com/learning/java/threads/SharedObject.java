package com.learning.java.threads;

public class SharedObject {

	String state;
	int counter;
	int max;

	public SharedObject(String state, int counter, int max) {
		this.state = state;
		this.counter = counter;
		this.max = max;
	}
	
	public boolean isEven() {
		return counter % 2 == 0;
	}

	public boolean isOdd() {
		return counter % 2 == 1;
	}

	public boolean isPrime() {
		if (counter <= 1) {
			return false;
		}
		for (int i = 2; i <= counter - 1; i++) {
			if (counter % i == 0) {
				return false;
			}
		}
		return true;
	}
}
