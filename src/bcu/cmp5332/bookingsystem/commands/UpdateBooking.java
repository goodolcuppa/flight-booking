package bcu.cmp5332.bookingsystem.commands;

import java.time.LocalDate;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class UpdateBooking implements Command {
	private int customerID;
	private int flightID;
	
	public UpdateBooking(int customerID, int  flightID) {
		this.customerID = customerID;
		this.flightID = flightID;
	}

	@Override
	public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
		// TODO Auto-generated method stub
		
		for(Booking booking : flightBookingSystem.getCustomerById(customerID).getBookings()) {
			if(booking.getFlight().getId() == flightID && booking.getStatus() != "cancelled") {
				booking.setBookingDate(LocalDate.now());
				booking.setStatus("rebooked");
				booking.setPrice(booking.getPrice() + 50);
				System.out.println("Your booking has been updated to this current time");
				return;
			}
		}
		throw new FlightBookingSystemException("This booking does not exist for this customer");
	}
	
	
	
}
