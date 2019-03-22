package com.company.service;

import com.company.Customer;
import com.company.MainHandler;
import com.company.TravelOffice;
import com.company.exeptions.NoSuchCustomerException;
import com.company.exeptions.NoSuchTripException;
import com.company.trips.Trip;

import java.util.HashMap;
import java.util.HashSet;

public class TravelOfficeService {

    private TravelOffice travelOffice;

    public boolean assign(Customer c, Trip t) throws NoSuchCustomerException {
        c = travelOffice.findCustomerByName(c.getName());
        t = travelOffice.getTrips().get(t.getDestination());

        c.assignTrip(t);

        if (c == null || c.getTrip() == null){
            return false;
        }
        return true;
    }

    public void setTravelOffice(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }

    public void addTrip(String tripName, Trip trip){
        travelOffice.addTrip(tripName, trip);
    }

    public boolean removeTrip(String tripName) throws NoSuchTripException {
        return travelOffice.removeTrip(tripName);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(name);
    }

    public boolean removeCustomer(Customer c) throws NoSuchCustomerException {
        return travelOffice.removeCustomer(c);
    }

    public Customer addCustomer(Customer c){
        return travelOffice.addCustomer(c);
    }

    public int getCustomerCount(){
        return travelOffice.getCustomerCount();
    }

    public HashMap<String, Trip> getTrips() {
        return travelOffice.getTrips();
    }

    public HashSet<Customer> getCustomers() {
        return travelOffice.getCustomers();
    }
}
