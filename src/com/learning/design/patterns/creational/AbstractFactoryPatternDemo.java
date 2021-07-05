package com.learning.design.patterns.creational;

import java.text.NumberFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AbstractFactoryPatternDemo {
	public static void main(String[] args) throws ParserConfigurationException {
		VehicleFactory vehicleFactory = AbstractVehicleFactory.getFactory("Car");
		if (vehicleFactory instanceof CarFactory) {
			System.out.println("Received Car Factory");
			CarFactory carFactory = (CarFactory) vehicleFactory;
			Vehicle car = carFactory.getCar("HatchBack");
			if (car instanceof HatchBack) {
				System.out.println("Received HatchBack car");
			}
		}

		// factory java examples
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		
		Calendar calendar = Calendar.getInstance();
		NumberFormat numberFormat = NumberFormat.getInstance();
		
	}
}

abstract class Vehicle {
	String company;
	String name;
}

abstract class Car extends Vehicle {

}

abstract class Bike extends Vehicle {

}

class HatchBack extends Car {
	
}

class Sedan extends Car {

}

class CommuterBike extends Bike {

}

class SuperBike extends Bike {

}

abstract class AbstractVehicleFactory {
	static VehicleFactory getFactory(String type) {
		switch (type) {
		case "Car":
			return new CarFactory();
		case "Bike":
			return new BikeFactory();
		}
		return null;
	}
}

abstract class VehicleFactory {

}

class CarFactory extends VehicleFactory {

	Car getCar(String type) {
		switch (type) {
		case "HatchBack":
			return new HatchBack();
		case "Sedan":
			return new Sedan();
		}
		return null;
	}

}

class BikeFactory extends VehicleFactory {
	Bike getBike(String type) {
		switch (type) {
		case "Commuter":
			return new CommuterBike();
		case "Super":
			return new SuperBike();
		}
		return null;
	}
}
