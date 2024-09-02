package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class CancelBooking implements Command{

	private final int customerID;
	private final int flightID;
	
	public CancelBooking(int customerID, int flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
	}
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		
		//gets the specific flight and customer based on the IDs given 
		Customer serviceCustomer = flightBookingSystem.getCustomerById(customerID);
		Flight serviceFlight = flightBookingSystem.getFlightByID(flightID);
		
		serviceCustomer.cancelBookingForFlight(serviceFlight);
		
		System.out.println("Customer: " + serviceCustomer.getName() + "has been removed from Flight: " + serviceFlight.getId() + " and their booking has been subsequently cancelled");
		
	}

}
