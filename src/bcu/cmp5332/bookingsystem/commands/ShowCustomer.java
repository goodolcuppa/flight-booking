package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ShowCustomer implements Command{

	private final int customerID;
	
	public ShowCustomer(int customerID) {
		this.customerID = customerID;
	}
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {

		if(flightBookingSystem.getCustomerById(customerID).getVisible() == true) {
			
			System.out.print(flightBookingSystem.getCustomerById(customerID).getDetailsLong());			
		}
		
	}

}
