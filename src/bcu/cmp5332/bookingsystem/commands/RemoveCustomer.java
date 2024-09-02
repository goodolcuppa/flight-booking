package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.*;

public class RemoveCustomer implements Command{

	private final int id;
	
	//constructor method for class
	public RemoveCustomer(int id) {
		this.id = id;
	}
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		
		//gets the customer and sets its hidden property, this process is one way, just setting the status to hidden
		Customer serviceCustomer = flightBookingSystem.getCustomerById(id);
		serviceCustomer.setVisibility(false);
		
		System.out.println("Customer: " + serviceCustomer.getName() + " has been removed");
		
	}

}
