package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ShowFlight implements Command{

	private final int flightID;
	
	public ShowFlight(int flightID) {
		this.flightID = flightID;
	}
	
	
	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		
		if(flightBookingSystem.getFlightByID(flightID).getVisibility() == true) {
			System.out.print(flightBookingSystem.getFlightByID(flightID).getDetailsLong());
		}
	}

}
