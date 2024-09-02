package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class FlightVisiblity implements Command{

	
	private int flightID;
	
	//constructor method for class
	public FlightVisiblity(int flightID) {
		this.flightID = flightID;
	}
	
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		//execute checks the current state of the flight and inverts its visibility, allowing the customer to be hidden and revealed from the listings
		if(flightBookingSystem.getFlightByID(flightID).getVisibility() == false) {
			flightBookingSystem.getFlightByID(flightID).setVisibility(true);
			System.out.println("Flight: " + flightBookingSystem.getFlightByID(flightID).getId() + " has been set to visible");
		}
		else {
			flightBookingSystem.getFlightByID(flightID).setVisibility(false);
			System.out.println("Flight: " + flightBookingSystem.getFlightByID(flightID).getId() + " has been set to hidden");
		}
	}

}
