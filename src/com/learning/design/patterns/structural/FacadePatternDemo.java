package com.learning.design.patterns.structural;

import java.util.Date;

public class FacadePatternDemo {

	public static void main(String[] args) {
		TravelFacade travelFacade =  new TravelFacade();
		travelFacade.book(BookingType.Flight_And_Hotel, new BookingInfo());
	}

}

class TravelFacade {
	FlightBooking flightBooking;
	TrainBooking trainBooking;
	HotelBooking hotelBooking;

	public TravelFacade() {
		flightBooking = new FlightBooking();
		trainBooking = new TrainBooking();
		hotelBooking = new HotelBooking();
	}

	public void book(BookingType type, BookingInfo info) {
		switch (type) {
		case Flight:
			// book flight;
			flightBooking.bookFlight(info);
			return;
		case Hotel:
			// book hotel;
			hotelBooking.bookHotel(info);
			return;
		case Train:
			// book Train;
			trainBooking.bookTrain(info);
			return;
		case Flight_And_Hotel:
			// book Flight and Hotel
			flightBooking.bookFlight(info);
			hotelBooking.bookHotel(info);
			return;
		case Train_And_Hotel:
			// book Train and Hotel
			trainBooking.bookTrain(info);
			hotelBooking.bookHotel(info);
			return;
		}
	}
}

class BookingInfo {
	String source;
	String destination;
	Date fromDate;
	Date toDate;
    String name;
}


class FlightBooking {
	public FlightBooking() {

	}

	public void bookFlight(BookingInfo info) {

	}
}

class HotelBooking {
	public HotelBooking() {

	}

	public void bookHotel(BookingInfo info) {

	}
}

class TrainBooking {
	public TrainBooking() {

	}

	public void bookTrain(BookingInfo info) {

	}
}

enum BookingType {
	Flight, Train, Hotel, Flight_And_Hotel, Train_And_Hotel;
};