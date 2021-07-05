package com.learning.design.patterns.behavioral;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		ToysOrder newOrder = new ToysOrder();
		newOrder.setPaymentStrategy(new CreditCard());
		newOrder.receive();
		newOrder.makePayment(100);
		if (newOrder.paymentStatus.equals("Failed")) {
			newOrder.setPaymentStrategy(new UPI());
			newOrder.makePayment(100);
		} else {
			newOrder.confirm();
		}
	}

}

interface PaymentStrategy {
	Boolean makePayment(int amount);
}

class ToysOrder {
	PaymentStrategy paymentStrategy;
	String paymentStatus = null;

	public PaymentStrategy getPaymentStrategy() {
		return paymentStrategy;
	}

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}

	public void receive() {
		System.out.println("Order received");
	}

	public void makePayment(int amount) {
		Boolean status = this.paymentStrategy.makePayment(amount);
		if (status) {
			this.paymentStatus = "Success";
			System.out.println("Order payment successful");
		} else {
			this.paymentStatus = "Failed";
			System.out.println("Order payment failed");
		}

	}

	public void confirm() {
		System.out.println("Order confirmed");
	}
}

class CreditCard implements PaymentStrategy {

	@Override
	public Boolean makePayment(int amount) {
		System.out.println("Payment of amount " + amount + " is failed through Credit Card");
		return false;
	}

}

class InternetBanking implements PaymentStrategy {

	@Override
	public Boolean makePayment(int amount) {
		System.out.println("Payment of amount " + amount + " is made through Internet Banking");
		return true;
	}

}

class UPI implements PaymentStrategy {

	@Override
	public Boolean makePayment(int amount) {
		System.out.println("Payment of amount " + amount + " is made through UPI");
		return true;
	}

}