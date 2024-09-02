package bcu.cmp5332.bookingsystem.commands;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class AddBooking implements Command{
	
	private final int customerID; 
	private final int flightID;

	public AddBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
	}
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {

		//gets the current local date for time of booking. based on when the method is called to add the booking to customer profile
		LocalDate ld = LocalDate.now();
		float priceCalc = (float) ((Math.round(((float) (flightBookingSystem.getFlightByID(flightID).getPrice() / ChronoUnit.DAYS.between(ld, flightBookingSystem.getFlightByID(flightID).getDepartureDate())))) * 100d) / 100d);

		Booking newBook = new Booking(
				flightBookingSystem.getCustomerById(customerID),
				flightBookingSystem.getFlightByID(flightID),
				ld,
				(flightBookingSystem.getFlightByID(flightID).getPrice() + priceCalc),
				"booked"
				);
		flightBookingSystem.getCustomerById(customerID).addBooking(newBook);
		flightBookingSystem.getFlightByID(flightID).addPassenger(flightBookingSystem.getCustomerById(customerID));		
		
		System.out.println("Customer: " + flightBookingSystem.getCustomerById(customerID).getName() + " has been successfully added to flight: " + flightBookingSystem.getFlightByID(flightID).getFlightNumber() + " and a booking has been subsequently added to their account");
	}

}
