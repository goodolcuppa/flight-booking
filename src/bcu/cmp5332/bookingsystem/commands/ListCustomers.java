package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ListCustomers implements Command{

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		int maxCustomers = 0;
		int hiddenCount = 0;
		String masterString = "";
		
		
		for(int i = 0; i < flightBookingSystem.getCustomers().size(); i++) {
			maxCustomers++;
			if(flightBookingSystem.getCustomers().get(i).getVisible() == true) {
				masterString += (flightBookingSystem.getCustomers().get(i).getDetailsShort() + "\n");
			}
			else {
				++hiddenCount;
			}
		}
		
		masterString += ((maxCustomers - hiddenCount) + " customers(s)\n");
		
		System.out.print(masterString);
	}

}
