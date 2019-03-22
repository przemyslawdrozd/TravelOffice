package com.company.service;

import com.company.Customer;
import com.company.TravelOffice;
import com.company.exeptions.NoSuchCustomerException;
import com.company.exeptions.NoSuchTripException;
import com.company.trips.AbroadTrip;
import com.company.trips.DomesticTrip;
import com.company.trips.Trip;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TravelOfficeTest {

//    @Mock
//    TravelOffice travelOffice;
//    @InjectMocks
//    TravelOfficeService travelOfficeService;

    private TravelOfficeService travelOfficeService;

    @Before
    public void setUp() {
        this.travelOfficeService = new TravelOfficeService();
        this.travelOfficeService.setTravelOffice(new TravelOffice());
    }

    @org.junit.Test
    public void addTripAbroad() {

        // Given
        AbroadTrip trip = new AbroadTrip(LocalDate.of(2000, 10, 15),
                LocalDate.of(2000, 10, 20), "Italy", 50, 300);
        String t = trip.getDestination();
        // When
        travelOfficeService.addTrip(t, trip);
        // Then
        assertNotNull(travelOfficeService.getTrips().get(t));
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void addTripAbroadWhenNull() {

        // Given
        AbroadTrip trip = null;
        String t = trip.getDestination();
        // When
        travelOfficeService.addTrip(t, trip);
        // Then
        assertNotNull(travelOfficeService.getTrips().get(t));
    }

    @Test
    public void addTripDomestic() {

        // Given
        DomesticTrip trip = new DomesticTrip(LocalDate.of(2000, 10, 15),
                LocalDate.of(2000, 10, 20), "Kato", 50, 300);
        String t = trip.getDestination();
        // When
        travelOfficeService.addTrip(t, trip);
        // Then
        assertNotNull(travelOfficeService.getTrips().get(t));
    }

    @Test(expected = NullPointerException.class)
    public void addTripDomesticWhenNull() {

        // Given
        DomesticTrip trip = null;
        String t = trip.getDestination();
        // When
        travelOfficeService.addTrip(t, trip);
        // Then
        assertNotNull(travelOfficeService.getTrips().get(t));
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void removeTripWhenNull() throws NoSuchTripException {

        // Given
        DomesticTrip t = null;
        // When
        travelOfficeService.removeTrip(t.getDestination());
        // Then
        assertNotNull(travelOfficeService.removeTrip(t.getDestination()));
    }

    @Test
    public void assign() throws NoSuchCustomerException {
        // Given
        Customer c = new Customer("test");
        AbroadTrip trip = new AbroadTrip(LocalDate.of(2000, 10, 15),
                LocalDate.of(2000, 10, 20), "Italy", 50, 300);

        // When
        travelOfficeService.addCustomer(c);
        travelOfficeService.addTrip(trip.getDestination(), trip);
        boolean b = travelOfficeService.assign(c, trip);

        // Then
        assertTrue(b);
    }

    @Test(expected = NullPointerException.class)
    public void assignNoTrip() throws NoSuchCustomerException {
        // Given
        Customer c = new Customer("test");
        DomesticTrip trip = null;

        // When
        travelOfficeService.addCustomer(c);
        boolean b = travelOfficeService.assign(c, trip);

        // Then
        assertTrue(b);
    }

    @Test(expected = NullPointerException.class)
    public void assignNoCustomer() throws NoSuchCustomerException {
        // Given
        Customer c = null;
        AbroadTrip trip = new AbroadTrip(LocalDate.of(2000, 10, 15),
                LocalDate.of(2000, 10, 20), "Italy", 50, 300);
        // When
        travelOfficeService.addTrip(trip.getDestination(), trip);
        boolean b = travelOfficeService.assign(c, trip);
        // Then
        assertTrue(b);
    }

    @Test(expected = NullPointerException.class)
    public void assignNoParameters() throws NoSuchCustomerException {
        // Given
        Customer c = null;
        AbroadTrip trip = null;
        // When
        boolean b = travelOfficeService.assign(c, trip);
        // Then
        assertTrue(b);
    }

    @org.junit.Test(expected = NoSuchCustomerException.class)
    public void findCustomerByNameWhenNull() throws NoSuchCustomerException {

        // Given
        String name = "name";
        // When
        travelOfficeService.findCustomerByName(name);
        // Then
        assertNotNull(travelOfficeService.findCustomerByName(name));
    }

    @org.junit.Test(expected = NoSuchCustomerException.class)
    public void removeCustomerWhenNull() throws NoSuchCustomerException {

        // Given
        Customer c = null;
        // When
        travelOfficeService.removeCustomer(c);
        // Then
        assertFalse(travelOfficeService.removeCustomer(c));
    }

    @org.junit.Test
    public void addCustomer() throws NoSuchCustomerException {

        // Given
        Customer c = new Customer("name");
        // When
        travelOfficeService.addCustomer(c);
        // Then
        assertNotNull(travelOfficeService.findCustomerByName(c.getName()));
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void addCustomerWhenNull() throws NoSuchCustomerException {

        // Given
        Customer c = null;
        // When
        travelOfficeService.addCustomer(c);
        // Then
        assertNotNull(travelOfficeService.findCustomerByName(c.getName()));
    }

    @org.junit.Test
    public void getCustomerCount() {

        // Given
        int customerSize;
        Customer c = new Customer("test");
        travelOfficeService.addCustomer(c);
        // When
        customerSize = travelOfficeService.getCustomerCount();
        // Then
        assertTrue(customerSize >= 0);
    }

    @org.junit.Test
    public void getCustomers() {

        // Given
        HashSet<Customer> customers;
        // When
        customers = travelOfficeService.getCustomers();
        // Then
        assertNotNull(customers);
    }

    @org.junit.Test
    public void getTrips() {

        // Given
        Map<String, Trip> trips;
        // When
        trips = travelOfficeService.getTrips();
        // Then
        assertNotNull(trips);
    }
}