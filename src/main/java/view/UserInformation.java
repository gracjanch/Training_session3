package view;

import controller.WeatherManagement;
import model.Location;
import controller.LocationManagement;
import model.Weather;

import java.util.List;
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
        final String path = "src/main/resources/weatherFiles/locations.csv";
        System.out.println("All locations: ");
        LocationManagement locationManagement = new LocationManagement(path);
        locationManagement.getListOfAllLocations().forEach(System.out::println);
    }

    public static void addLocation() {
        Location location = new Location(
                UserInformation.getInfoFromUser("Type coordinates"),
                UserInformation.getInfoFromUser("Type city"),
                UserInformation.getInfoFromUser("Type region"),
                UserInformation.getInfoFromUser("Type country")
        );

        LocationManagement locationManagement = new LocationManagement("src/main/resources/weatherFiles/locations.csv");
        locationManagement.addLocation(location);
    }

    public static void displayWeather() {
        WeatherManagement weatherManagement = new WeatherManagement("src/main/resources/weatherFiles/weather.csv");
        weatherManagement.getListOfWeatherToDisplay().forEach(System.out::println);
    }
}
