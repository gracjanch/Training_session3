package view;

import model.Location;
import controller.LocationManagement;

import java.util.Scanner;

public class UserInformation {
    public static void initialInfo() {
        System.out.println("===== Weather Application =====");
    }

    public static void options() {
        System.out.println("[1] - Add location.");
        System.out.println("[2] - Display all locations.");
        System.out.println("[3] - Show weather.");
        System.out.println("[4] - Quit.");
        System.out.print("Choose an option: ");
    }

    public static void infoToUser(String info) {
        System.out.println(info);
    }

    public static String getInfoFromUser(String infoToUser) {
        System.out.println(infoToUser);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void displayAllLocations() {
        System.out.println("All locations: ");
        LocationManagement locationManagement = new LocationManagement();
        locationManagement.getListOfAllLocations().forEach(System.out::println);
    }

    public static void addLocation() {
        Location location = new Location(
                UserInformation.getInfoFromUser("Type coordinates"),
                UserInformation.getInfoFromUser("Type city"),
                UserInformation.getInfoFromUser("Type region"),
                UserInformation.getInfoFromUser("Type country")
        );

        LocationManagement locationManagement = new LocationManagement();
        locationManagement.addLocation(location);
    }
}
