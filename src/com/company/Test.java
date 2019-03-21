package com.company;

import java.util.Scanner;

public class Test {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
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
