package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class TravelOffice {

    private HashSet<Customer> customers = new HashSet<>();
    private HashMap<String, Trip> trips = new HashMap<>();

    public void addTrip(String tripName, Trip trip){
        trips.put(tripName, trip);
    }

    public boolean removeTrip(String tripName){
        if (trips.containsKey(tripName)) {
            trips.remove(tripName);
            return true;
        }
        return false;
    }

    public Customer findCustomerByName(String name){
        for (Customer c: customers){
            if (c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public boolean removeCustomer(Customer c){
        return customers.remove(c);
    }

    public Customer addCustomer(Customer customer){
        if (customer != null){
            customers.add(customer);
            return customer;
        }
        return null;
    }

    public void getCustomerCount(){
        System.out.println("Amount of Customers: " + customers.size());
    }

    public HashSet<Customer> getCustomers() {
        return customers;
    }

    public HashMap<String, Trip> getTrips() {
        return trips;
    }

    @Override
    public String toString(){
        String returnInfo = "";
        for (Customer c: customers){
            if (c != null) {
                returnInfo += c.toString() + "\n\n";
            }
        }
        return returnInfo;
    }
}













