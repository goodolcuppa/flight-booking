package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class CustomerVisibility implements Command{

private int customerID;
	
	//constructor method for the class
	public CustomerVisibility(int customerID) {
		this.customerID = customerID;
	}
	
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		//execute checks the current state of the customer and inverts its visibility, allowing the customer to be hidden and revealed from the listings
		if(flightBookingSystem.getCustomerById(customerID).getVisible() == false) {
			flightBookingSystem.getCustomerById(customerID).setVisibility(true);;
			System.out.println("Customer: " + flightBookingSystem.getCustomerById(customerID).getID() + " " + flightBookingSystem.getCustomerById(customerID).getName() +" has been set to visible");
		}
		else {
			flightBookingSystem.getCustomerById(customerID).setVisibility(false);
			System.out.println("Customer: " + flightBookingSystem.getCustomerById(customerID).getID() + " " + flightBookingSystem.getCustomerById(customerID).getName() + " has been set to hidden");
		}
	}

}

