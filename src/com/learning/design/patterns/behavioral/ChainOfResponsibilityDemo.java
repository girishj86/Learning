package com.learning.design.patterns.behavioral;

public class ChainOfResponsibilityDemo {

	public static void main(String[] args) {
		NegativeProcessor negativeProcessor =  new NegativeProcessor();
		ZeroProcessor zeroProcessor =  new ZeroProcessor();
		PositiveProcessor positiveProcessor = new PositiveProcessor();
		
		negativeProcessor.setNext(zeroProcessor);
		zeroProcessor.setNext(positiveProcessor);
		
		negativeProcessor.handleRequest(-3);
		negativeProcessor.handleRequest(0);
		negativeProcessor.handleRequest(3);

	}

}

interface Processor {
	void handleRequest(int number);
}

class NegativeProcessor implements Processor {

	Processor next;

	@Override
	public void handleRequest(int number) {
		if (number < 0) {
			System.out.println("Number " + number + " is neagtive. Processed by Negative Processor");
		} else {
			System.out.println("Not processed by Negative Processor. Passing on to next handler");
			next.handleRequest(number);
		}
	}

	public void setNext(Processor next) {
		this.next = next;
	}
	
}

class ZeroProcessor implements Processor {

	Processor next;

	@Override
	public void handleRequest(int number) {
		if (number == 0) {
			System.out.println("Number " + number + " is zero. Processed by Zero Processor");
		} else {
			System.out.println("Not processed by Zero Processor. Passing on to next handler");
			next.handleRequest(number);
		}
	}
	
	public void setNext(Processor next) {
		this.next = next;
	}
}

class PositiveProcessor implements Processor {

	Processor next;

	@Override
	public void handleRequest(int number) {
		if (number > 0) {
			System.out.println("Number " + number + " is positive. Processed by Positive Processor");
		} else {
			System.out.println("Invalid number. Could not be processed");
		}
	}
	
	public void setNext(Processor next) {
		this.next = next;
	}
}