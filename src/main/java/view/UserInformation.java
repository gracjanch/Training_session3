package view;


import model.entity.Country;
import model.entity.Location;
import service.LocationService;
import service.WeatherManagement;
import validation.LocationValidate;

import java.util.Scanner;

public class UserInformation {
    private static final LocationService locationService = new LocationService();
    private static final LocationValidate locationValidate = new LocationValidate();

    public void initialInfo() {
        System.out.println("===== Weather Application =====");
    }

    public void options() {
        System.out.println("[1] - Add location.");
        System.out.println("[2] - Display all locations.");
        System.out.println("[3] - Show weather.");
        System.out.println("[4] - Quit.");
        System.out.print("Choose an option: ");
    }

    public void toUser(String info) {
        System.out.println(info);
    }

    public String getInfoFromUser(String infoToUser) {
        System.out.println(infoToUser);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void displayAllLocations() {
        System.out.println("List of all locations: ");
        locationService.getListOfAllLocations()
                .forEach(System.out::println);
    }

//    private static void addLocationMessages(int indeks) {
//        String[] locationMessages = {"Write coordinates: (example: 40x100)",
//                "Write city name: (cannot be empty)",
//                "Write region: (optional)",
//                "Write country name: (cannot be empty)"};
//        System.out.println(locationMessages[indeks]);
//    }

    public void displayWeather() {
        WeatherManagement weatherManagement = new WeatherManagement("src/main/resources/weatherFiles/locations.csv",
                "src/main/resources/weatherFiles/weather.csv");
        weatherManagement.getListOfWeatherToDisplay().forEach(System.out::println);
    }
    public void addLocation() {
        Location location = Location.builder()
                .id(locationValidate.validateCityId())
                .coordinates(locationValidate.validateCoordinates())
                .city(locationValidate.validateCityOrCountry("city name"))
                .region(locationValidate.validateRegion())
                .country(
                        Country.builder()
                                .countryId(locationValidate.validateCountryId())
                                .countryName(locationValidate.validateCityOrCountry("country name"))
                                .build()
                )
                .build();

        locationService.addLocation(location);


//        addLocationMessages(0);
//        String coordinates = LocationValidate.validCoordinate();
//        addLocationMessages(1);;
//        String city = LocationValidate.validateCityOrCountry();
//        addLocationMessages(2);;
//        String region = UserManagement.userChoice();
//        addLocationMessages(3);;
//        String country = LocationValidate.validateCityOrCountry();
        }
}
