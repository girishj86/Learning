package com.learning.design.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		StockObserver so1 = new StockObserver("Observer1");
		StockObserver so2 = new StockObserver("Observer2");
		StockObserver so3 = new StockObserver("Observer3");

		Stock stock = new Stock();
		stock.registerObserver(so1);
		stock.registerObserver(so2);
		stock.registerObserver(so3);

		stock.changePriceAndNotifyObservers(100);
		stock.changePriceAndNotifyObservers(110);

		stock.removeObserver(so2);
		stock.changePriceAndNotifyObservers(105);
	}
}

interface Observer {
	public void update(String message);
}

class StockObserver implements Observer {
	String name;

	public StockObserver(String name) {
		this.name = name;
	}

	@Override
	public void update(String message) {
		System.out.println("StockObserver: " + this.name + " received the message: " + message);
	}
}

interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void changePriceAndNotifyObservers(int newPrice);
}

class Stock implements Subject {
	
	List<Observer> observers = new ArrayList<>();
	int price;

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void changePriceAndNotifyObservers(int newPrice) {
		this.price = newPrice;
		observers.stream().forEach(o -> o.update("Stock price changed to " + this.price));
	}

	public void setPrice(int price) {
		this.price = price;
	}

}