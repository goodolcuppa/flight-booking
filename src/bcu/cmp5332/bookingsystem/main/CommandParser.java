package bcu.cmp5332.bookingsystem.main;

import bcu.cmp5332.bookingsystem.commands.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CommandParser {
    
    public static Command parse(String line) throws IOException, FlightBookingSystemException {
        try {
            String[] parts = line.split(" ", 3);
            String cmd = parts[0];

            
            if (cmd.equals("addflight")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Flight Number: ");
                String flightNumber = reader.readLine();
                System.out.print("Origin: ");
                String origin = reader.readLine();
                System.out.print("Destination: ");
                String destination = reader.readLine();
                System.out.print("Capacity: ");
                String capacity = reader.readLine();
                System.out.print("Price: ");
                String price = reader.readLine();

                LocalDate departureDate = parseDateWithAttempts(reader);

                return new AddFlight(flightNumber, origin, destination, departureDate,Integer.parseInt(capacity), Float.parseFloat(price));
            } else if (cmd.equals("addcustomer")) {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            	System.out.print("Customer name: ");
            	String name = reader.readLine();
            	System.out.print("Customer phone number: ");
            	String phone = reader.readLine();
            	System.out.print("Customer E-mail: ");
            	String email = reader.readLine();
            	
            	return new AddCustomer(name, phone,email);
            } else if (cmd.equals("loadgui")) {
                return new LoadGUI();
            } else if (parts.length == 1) {
                if (line.equals("listflights")) {
                    return new ListFlights();
                } else if (line.equals("listcustomers")) {
                    return new ListCustomers();
                } else if (line.equals("help")) {
                    return new Help();
                }
            } else if (parts.length == 2) {
                int id = Integer.parseInt(parts[1]);

                if (cmd.equals("showflight")) {
                    return new ShowFlight(id);
                } else if (cmd.equals("showcustomer")) {
                    return new ShowCustomer(id);
                } else if(cmd.equals("flightvisibility")) {
                	return new FlightVisiblity(id);
                } else if(cmd.equals("customervisibility")) {
                	return new CustomerVisibility(id);
                }else if(cmd.equals("removecustomer")) {
                	return new RemoveCustomer(id);
                }else if(cmd.equals("removeflight")) {
                	return new RemoveFlight(id);
                }
            } else if (parts.length == 3) {
                int customerId = Integer.parseInt(parts[1]);
                int flightId = Integer.parseInt(parts[2]);

                if (cmd.equals("addbooking")) {
                    return new AddBooking(customerId, flightId);
                } else if (cmd.equals("editbooking")) {
                    return new UpdateBooking(customerId,flightId);
                } else if (cmd.equals("cancelbooking")) {
                    return new CancelBooking(customerId, flightId);
                }
            }
        } catch (NumberFormatException ex) {

        }

        throw new FlightBookingSystemException("Invalid command.");
    }
    
    private static LocalDate parseDateWithAttempts(BufferedReader br, int attempts) throws IOException, FlightBookingSystemException {
        if (attempts < 1) {
            throw new IllegalArgumentException("Number of attempts should be higher that 0");
        }
        while (attempts > 0) {
            attempts--;
            System.out.print("Departure Date (\"YYYY-MM-DD\" format): ");
            try {
                LocalDate departureDate = LocalDate.parse(br.readLine());
                return departureDate;
            } catch (DateTimeParseException dtpe) {
                System.out.println("Date must be in YYYY-MM-DD format. " + attempts + " attempts remaining...");
            }
        }
        
        throw new FlightBookingSystemException("Incorrect departure date provided. Cannot create flight.");
    }
    
    private static LocalDate parseDateWithAttempts(BufferedReader br) throws IOException, FlightBookingSystemException {
        return parseDateWithAttempts(br, 3);
    }
}