package com.company;

import com.company.exeptions.NoSuchCustomerException;
import com.company.exeptions.NoSuchTripException;
import com.company.trips.Trip;

import java.util.HashMap;
import java.util.HashSet;

public class TravelOffice {

    private HashSet<Customer> customers = new HashSet<>();
    private HashMap<String, Trip> trips = new HashMap<>();

    public void addTrip(String tripName, Trip trip) {
        trips.put(tripName, trip);
    }

    public boolean removeTrip(String tripName) throws NoSuchTripException {
        if (trips.containsKey(tripName)) {
            trips.remove(tripName);
            return true;
        }
        throw new NoSuchTripException("Trip not founded");
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        throw new NoSuchCustomerException("Customer not founded");
    }

    public boolean removeCustomer(Customer c) throws NoSuchCustomerException {
        if (customers.remove(c)) {
            return true;
        }
        throw new NoSuchCustomerException("Customer not founded");
    }

    public Customer addCustomer(Customer customer) {
        if (customer != null) {
            customers.add(customer);
            return customer;
        }
        return null;
    }

    public void getCustomerCount() {
        System.out.println("Amount of Customers: " + customers.size());
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public HashMap<String, Trip> getTrips() {
        return trips;
    }

    @Override
    public String toString() {
        String returnInfo = "";
        for (Customer c : customers) {
            if (c != null) {
                returnInfo += c.toString() + "\n\n";
            }
        }
        return returnInfo;
    }
}













