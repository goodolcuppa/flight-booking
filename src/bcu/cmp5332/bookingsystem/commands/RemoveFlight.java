package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.*;

public class RemoveFlight implements Command{

	private final int id;
	
	//constructor method for class
	public RemoveFlight(int id) {
		this.id = id;
	}
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		
		//gets the flight and sets its hidden property, this process is one way, just setting the status to hidden
		Flight serviceFlight = flightBookingSystem.getFlightByID(id);
		serviceFlight.setVisibility(false);
		System.out.println("Flight: " + serviceFlight.getFlightNumber() + " has been removed");
		
	}

}
