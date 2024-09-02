package bcu.cmp5332.bookingsystem.model;

import java.time.LocalDate;

public class Booking {
    
    private Customer customer;
    private Flight flight;
    private LocalDate bookingDate;
    private float price;
    private String status;
    

    public Booking(Customer customer, Flight flight, LocalDate bookingDate, float price, String status) {
        // TODO: implementation here
    	this.customer = customer;
    	this.flight = flight;
    	this.bookingDate = bookingDate;
        this.price = price;
        this.status = status;
    }
    
    // TODO: implementation of Getter and Setter methods
    
    //getter methods for Booking class
    public Customer getCustomer() {
    	return this.customer;
    }
    
    public Flight getFlight() {
    	return this.flight;
    }
    
    public LocalDate getBookingDate() {
    	return this.bookingDate;
    }
    
    public float getPrice() {
    	return this.price;
    }
    
    public String getStatus() {
    	return this.status;
    }
    
    //setter methods for Booking class
    public void setCustomer(Customer newData) {
    	customer = newData;
    }
    
    public void setFlight(Flight newData) {
    	flight = newData;
    }
    
    public void setBookingDate(LocalDate newData) {
    	bookingDate = newData;
    }
    
    public void setPrice(float price) {
    	this.price = price;
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
}
