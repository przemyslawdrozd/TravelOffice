package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class MainHandler implements UserInterface{

    private Scanner scanner = new Scanner(System.in);
    private TravelOffice travelOffice;

    public MainHandler(){
        System.out.println("1. Dodaj Klienta\n" +
                "2. Dodaj Wycieczke\n" +
                "3. Przypisz wycieczke do klienta\n" +
                "4. Usun klienta\n" +
                "5. Usun wycieczke\n" +
                "6. Pokaz klientów\n" +
                "7. Pokaz wycieczki\n" +
                "8. Wyjdz"
        );
        travelOffice = new TravelOffice();
    }

    @Override
    public Customer addCustomer() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.println("Adres - street, zip, city: ");
        String street = scanner.next();
        String zip = scanner.next();
        String city = scanner.next();

        Customer customer = new Customer(name);
        Address address = new Address(street,zip,city);
        customer.setAddress(address);
        travelOffice.addCustomer(customer);
        System.out.println("Klient dodany do bazy!");
        scanner.nextLine();
        return customer;
    }

    @Override
    public Trip addTrip() {
        System.out.println("choice Trip: \n" +
                "1. Domestic Trip\n" +
                "2. Abroad Trip");
        String choice = scanner.next();
        String destination;

        switch (choice){
            case "1":
                System.out.println("Cel wycieczki:");
                destination = scanner.next();
                DomesticTrip domesticTrip = new DomesticTrip(new Date(2000,10,10),
                        new Date(2000, 10, 17), destination,
                        200, 500);
                travelOffice.addTrip(destination, domesticTrip);
                scanner.nextLine();
                return domesticTrip;
            case "2":
                System.out.println("Cel wycieczki:");
                destination = scanner.next();
                AbroadTrip abroadTrip = new AbroadTrip(new Date(2000,10,10),
                        new Date(2000, 10, 17), destination,
                        200, 2500);
                travelOffice.addTrip(destination, abroadTrip);
                scanner.nextLine();
                return abroadTrip;
        }
        return null;
    }

    @Override
    public void assign() {
        System.out.println("Podaj imie klienta: ");
        String name = scanner.next();
        System.out.println("Podaj wycieczke: ");
        String destination = scanner.next();

        for (Customer c: travelOffice.getCustomers()){
            if (c.getName().equals(name)){
                for (String t: travelOffice.getTrips().keySet()){
                    if (t.equals(destination)){
                        Trip trip = travelOffice.getTrips().get(destination);
                        System.out.println("Klient " + name + " dodany do wycieczki " + destination);
                        c.assignTrip(trip);
                        return;
                    }
                }
                System.out.println("Nie ma takiej wycieczki");
                return;
            }
        }
        System.out.println("Nie ma takiego klienta");
    }

    @Override
    public boolean removeCustomer() {
        System.out.println("Podaj imie klienta:");
        String name = scanner.next();

        for (Customer c: travelOffice.getCustomers()){

            if (c.getName().equals(name)){
                System.out.println("Klinet " + name + " usuniety!");
                travelOffice.removeCustomer(c);
                return true;
            }
        }
        System.out.println("Klient " + name + " nie istnieje!");
        return false;
    }

    @Override
    public boolean removeTrip() {
        System.out.println("Podaj nazwe wycieczki zeby usunąc:");
        String destination = scanner.next();

        for (String t: travelOffice.getTrips().keySet()){

            if (t.equals(destination)){
                System.out.println("Wycieczka do " + destination + " usunieta!");
                travelOffice.getTrips().remove(destination);
                return true;
            }
        }
        System.out.println("Nie ma takiej wycieczki!");
        return false;
    }

    @Override
    public void showTrips() {
        for (String t: travelOffice.getTrips().keySet()){
            System.out.println(t);
        }
    }

    @Override
    public void showCustomers() {
        if (travelOffice.getCustomers() != null) {
            for (Customer c : travelOffice.getCustomers()) {
                if (c.getTrip() != null){
                    System.out.println(c);
                } else {
                    System.out.println(c.getName() + ": brak wycieczki");
                }
            }
            return;
        }
        System.out.println("Nie ma klientów");
    }
}
