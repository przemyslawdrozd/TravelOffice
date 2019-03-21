package com.company;

import java.util.Scanner;

public class Test {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        showMenu();

//        TravelOffice travelOffice = new TravelOffice();
////
////        Address address = new Address("Azot", "43-600", "Jaworzno");
////        Customer customer = new Customer("Przemek");
////        DomesticTrip trip = new DomesticTrip(new Date(2019,1,10),
////                new Date(2019,2, 12), "Katowice", 150, 500);
////        customer.assignTrip(trip);
////        customer.setAddress(address);
////        travelOffice.addCustomer(customer);
////
////        address = new Address("Matejki", "43-600", "Jaworzno");
////        customer = new Customer("Tomek");
////        trip = new DomesticTrip(new Date(2019, 2,13),
////                new Date( 2019, 3, 14), "Katowice", 70, 500);
////        customer.assignTrip(trip);
////        customer.setAddress(address);
////        travelOffice.addCustomer(customer);
////
////        address = new Address("Chopina", "43-600", "Jaworzno");
////        customer = new Customer("Marek");
////        AbroadTrip trip2 = new AbroadTrip(new Date(2019, 3,15),
////                new Date( 2019, 4, 16), "Katowice", 50, 500);
////        customer.assignTrip(trip2);
////        customer.setAddress(address);
////        travelOffice.addCustomer(customer);
////
////        address = new Address("Mieszka I", "43-600", "Jaworzno");
////        customer = new Customer("Janusz");
////        trip2 = new AbroadTrip(new Date(2019, 4,17),
////                new Date( 2019, 5, 18), "Katowice", 60, 500);
////        customer.assignTrip(trip2);
////        customer.setAddress(address);
////        travelOffice.addCustomer(customer);
////
////        travelOffice.getCustomerCount();
////        System.out.println(travelOffice.toString());

    }

    private static void showMenu(){
        MainHandler mainHandler = new MainHandler();
        String choice = scanner.next();

        while (!choice.equals("8")) {
            switch (choice) {
                case "1":
                    mainHandler.addCustomer();
                    break;
                case "2":
                    mainHandler.addTrip();
                    break;
                case "3":
                    mainHandler.assign();
                    break;
                case "4":
                    mainHandler.removeCustomer();
                    break;
                case "5":
                    mainHandler.removeTrip();
                    break;
                case "6":
                    mainHandler.showCustomers();
                    break;
                case "7":
                    mainHandler.showTrips();
                    break;
            }
            System.out.println("Next action: ");
            choice = scanner.next();
        }
        System.out.println("Exit!");
    }
}
