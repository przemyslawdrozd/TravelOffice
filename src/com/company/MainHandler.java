package com.company;

import com.company.exeptions.NoSuchCustomerException;
import com.company.exeptions.NoSuchTripException;

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
        String start;
        String end;
        int price;

        switch (choice){
            case "1":
                System.out.println("Cel wycieczki:");
                destination = scanner.next();
                scanner.nextLine();

                System.out.println("Początek wycieczki (d-m-r): ");
                start = scanner.next();
                scanner.nextLine();

                System.out.println("Koniec wycieczki (d-m-r): ");
                end = scanner.next();
                scanner.nextLine();

                System.out.println("Price: ");
                price = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Own Arrival Discount:");
                int ownArrivalDiscount = scanner.nextInt();
                DomesticTrip domesticTrip = new DomesticTrip(Date.of(start), Date.of(end),
                                        destination, ownArrivalDiscount, price);

                travelOffice.addTrip(destination, domesticTrip);
                scanner.nextLine();

                System.out.println("Wycieczka dodana!");
                return domesticTrip;

            case "2":
                System.out.println("Cel wycieczki:");
                destination = scanner.next();
                scanner.nextLine();

                System.out.println("Początek wycieczki (d-m-r): ");
                start = scanner.next();
                scanner.nextLine();

                System.out.println("Koniec wycieczki (d-m-r): ");
                end = scanner.next();
                scanner.nextLine();

                System.out.println("Price: ");
                price = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Insurance: ");
                int insurance = scanner.nextInt();
                AbroadTrip abroadTrip = new AbroadTrip(Date.of(start), Date.of(end),
                        destination, insurance, price);

                travelOffice.addTrip(destination, abroadTrip);
                scanner.nextLine();

                System.out.println("Wycieczka dodana!");
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
        scanner.nextLine();

        Customer customer;
        try {
            customer = travelOffice.findCustomerByName(name);
            for (String t: travelOffice.getTrips().keySet()){
                if (t.equals(destination)){
                    Trip trip = travelOffice.getTrips().get(destination);
                    System.out.println("Klient " + name + " dodany do wycieczki " + destination);
                    customer.assignTrip(trip);
                    return;
                }
            }
            System.out.println("Nie ma takiej wycieczki");
            return;
        } catch (NoSuchCustomerException noSuchCustomerExeption) {
            noSuchCustomerExeption.printStackTrace();
        }
        System.out.println("Nie ma takiego klienta");
    }

    @Override
    public boolean removeCustomer() {
        System.out.println("Podaj imie klienta:");
        String name = scanner.next();

        for (Customer c: travelOffice.getCustomers()){
            if (c.getName().equals(name)){
                try {
                    travelOffice.removeCustomer(c);
                    System.out.println("Klinet " + name + " usuniety!");
                } catch (NoSuchCustomerException e) {
                    e.printStackTrace();
                }
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
                try {
                    travelOffice.removeTrip(destination);
                    System.out.println("Wycieczka do " + destination + " usunieta!");
                } catch (NoSuchTripException noSuchTripExeption) {
                    noSuchTripExeption.printStackTrace();
                }
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
                    System.out.println("Name: " + c.getName() + " - brak wycieczki");
                }
            }
            return;
        }
        System.out.println("Nie ma klientów");
    }
}
