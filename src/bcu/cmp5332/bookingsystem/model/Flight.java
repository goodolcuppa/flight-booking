package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Flight {
    
    private int id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDate departureDate;
    private int capacity;
    private float price;
    private boolean visible;

    private final Set<Customer> passengers;

    public Flight(int id, String flightNumber, String origin, String destination, LocalDate departureDate, int capacity, float price,boolean visible) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.capacity = capacity;
        this.price = price;
        this.visible = visible;
        
        passengers = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    
    public int getCapacity() {
    	return this.capacity;
    }
    
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    }
    
    public float getPrice() {
    	return this.price;
    }
    
    public void setPrice(float price) {
    	this.price = price;
    }

    public boolean getVisibility() {
    	return this.visible;
    }
    
    public void setVisibility(boolean visibility) {
    	this.visible = visibility;
    }
    
    public List<Customer> getPassengers() {
        return new ArrayList<>(passengers);
    }
	
    public String getDetailsShort() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        return "Flight #" + id + " - " + flightNumber + " - " + origin + " to " 
                + destination + " on " + departureDate.format(dtf);
    }

    public String getDetailsLong() {
        // TODO: implementation here
    	int maxVal = 0;
    	String returnVal = ("Flight #" + id + "\nFlight No: " + flightNumber + "\nOrigin: " + origin + "\nDestination: " + destination + "\nDeparture Date: " + departureDate + "\n---------------------------\nPassengers:\n");
    	for (int i = 0 ; i < passengers.size() ; i++) {
    		returnVal += (" * Id: " + this.getPassengers().get(i).getID() + " - " + this.getPassengers().get(i).getName() + " - " + this.getPassengers().get(i).getPhone() + "\n");
    		maxVal++;
    	}
    	returnVal += (maxVal + "passenger(s)\n");
    	
        return returnVal;
    }
    
    public void addPassenger(Customer passenger) throws FlightBookingSystemException {
    	for(int i = 0; i < passengers.size() ; i++) {
    		if(passenger == this.getPassengers().get(i)) {
    			throw new FlightBookingSystemException("Passenger is already present");
    		}
    	}
    	passengers.add(passenger);
    }
    
    public void removePassenger(Customer passenger) throws FlightBookingSystemException {
    	for(int i = 0; i < passengers.size() ; i++) {
    		if(passenger == this.getPassengers().get(i)) {
    			passengers.remove(passenger);
    			return; 
    		}
    	}
    	throw new FlightBookingSystemException("Passenger is already not present");
    }
}
