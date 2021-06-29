package com.learning.java.threads;

public class SharedObject {

	String status;
	int counter;
	int max;

	public SharedObject(String status, int counter, int max) {
		this.status = status;
		this.counter = counter;
		this.max = max;
	}
}
