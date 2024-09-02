package bcu.cmp5332.bookingsystem.data;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class BookingDataManager implements DataManager {
    
    public final String RESOURCE = "./resources/data/bookings.txt";

    @Override
    public void loadData(FlightBookingSystem fbs) throws IOException, FlightBookingSystemException {
    	try (Scanner sc = new Scanner(new File(RESOURCE))) {
            int line_idx = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] properties = line.split(SEPARATOR, -1);
                try {
                    int customerId = Integer.parseInt(properties[0]);
                    int flightId = Integer.parseInt(properties[1]);
                    LocalDate bookingDate = LocalDate.parse(properties[2]);
                    float price = Float.parseFloat(properties[3]);
                    String status = properties[4];
                    Booking booking = new Booking(fbs.getCustomerById(customerId), fbs.getFlightByID(flightId), bookingDate, price, status);
                    fbs.getCustomerById(customerId).addBooking(booking);
                } catch (NumberFormatException ex) {
                    throw new FlightBookingSystemException("Unable to parse book id " + properties[0] + " on line " + line_idx
                        + "\nError: " + ex);
                }
                line_idx++;
            }
        }
    }

    @Override
    public void storeData(FlightBookingSystem fbs) throws IOException {
    	try (PrintWriter out = new PrintWriter(new FileWriter(RESOURCE))) {
            for (Customer customer : fbs.getCustomers()) {
            	for (Booking booking : customer.getBookings()) {
            		out.print(booking.getCustomer().getID() + SEPARATOR);
            		out.print(booking.getFlight().getId() + SEPARATOR);
            		out.print(booking.getBookingDate() + SEPARATOR);
            		out.print(booking.getPrice() + SEPARATOR);
            		out.print(booking.getStatus() + SEPARATOR);
                    out.println();
            	}
            }
        }
    }
    
}
