package com.company;

import com.company.trips.Trip;

public class Customer {

    private String name;
    private Address address;
    private Trip trip;

    public Customer(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                address.toString() + "\n" +
                trip.toString();
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Trip getTrip() {
        return trip;
    }
}
