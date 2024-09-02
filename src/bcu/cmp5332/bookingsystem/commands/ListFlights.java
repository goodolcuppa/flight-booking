package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ListFlights implements Command {

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
        int hiddenCount = 0;
        LocalDate current = LocalDate.now();
    	List<Flight> flights = flightBookingSystem.getFlights();
        for (Flight flight : flights) {
        	if(flight.getVisibility() && (flight.getDepartureDate().isAfter(current))) {
        		float priceCalc = (float) (Math.round(((float) (flight.getPrice() / ChronoUnit.DAYS.between(LocalDate.now(), flight.getDepartureDate()))) * 1d) / 1d);
        		System.out.println(flight.getDetailsShort() + "Current price:" + flight.getPrice() + priceCalc);
        	}
        	else {
        		++hiddenCount;
        	}
        }
        System.out.println((flights.size() - hiddenCount) + " flight(s)");
    }
}
