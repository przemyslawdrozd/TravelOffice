package com.company;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {

    private static Logger globalLogger = Logger.getLogger("");
    private static Logger logger = Logger.getLogger("TravelOffice");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Handler[] handlers = globalLogger.getHandlers();
        for (Handler h: handlers){
            globalLogger.removeHandler(h);
        }

        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("start");
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
