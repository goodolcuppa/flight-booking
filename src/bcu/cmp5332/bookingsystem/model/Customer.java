package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private int id;
    private String name;
    private String phone;
    private String email;
    private boolean visible;
    private final List<Booking> bookings = new ArrayList<>();
    
    // TODO: implement constructor here
    public Customer(int id, String name, String phone, String email,boolean visible) {
    	this.id = id;
    	this.name = name;
    	this.phone = phone;
    	this.email = email;
    	this.visible = visible;
    }
    
    // TODO: implementation of Getter and Setter methods
    
    //getter methods for Customer class
    public int getID() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public boolean getVisible() {
    	return this.visible;
    }
    
    
    public List<Booking> getBookings(){
    	return this.bookings;
    }
    
    //setter methods for Customer class
    public void setID(int newData) {
    	this.id = newData;
    }
    
    public void setName(String newData) {
    	this.name = newData;
    }
    
    public void setPhone(String newData) {
    	this.phone = newData;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setVisibility(boolean visible) {
    	this.visible = visible;
    }
    
    public String getDetailsShort() {
    	return ("Customer: #" + id + " Name: " + name + " Phone: " + phone);
    }
    
    public String getDetailsLong() {
    	String longDetail = null;
    	int bookingNo = 0;
    	
    	longDetail = ("Customer #" + id + "\nName: " + name + "\nPhone: "+ phone +"\n--------------------------\n");
    	
    	if(bookings.size() > 0) {
    		longDetail += ("Bookings:\n");
    		for (int i = 0 ; i < bookings.size(); i++) {
    			longDetail += (" * Booking date: " + bookings.get(i).getBookingDate() + " for " + bookings.get(i).getFlight().getFlightNumber() + " Cost: " + bookings.get(i).getPrice()+ " Status: "+bookings.get(i).getStatus() +"\n");
    			bookingNo++;
    		}
    	}
    	
    	longDetail += (bookingNo + "booking(s)\n");
    	return longDetail;
    }
    
    public void addBooking(Booking booking) throws FlightBookingSystemException {
        // TODO: implementation here
    	for (int i = 0 ; i < bookings.size() ; i++) {
    		if(bookings.get(i) == booking) {
    			throw new FlightBookingSystemException("Booking already exists");
    		}
    	}
    	bookings.add(booking);
    }

    public void cancelBookingForFlight(Flight flight) throws FlightBookingSystemException {
    	
    	for (int i = 0 ; i < bookings.size() ; i++) {
    		if(bookings.get(i).getFlight() == flight && bookings.get(i).getStatus() != "cancelled") {
    			bookings.get(i).setStatus("cancelled");
    			bookings.get(i).setPrice(bookings.get(i).getPrice() + 100);
    			bookings.get(i).getFlight().removePassenger(this);
    			return;
    		}
    	}
    	
    	//if code cycles through all elements and does not find a match, error is raised at this part of the code
    	throw new FlightBookingSystemException("Flight does not exist in customer record");
    }
}

