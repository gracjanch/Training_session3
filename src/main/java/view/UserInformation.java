package view;


import model.entity.Country;
import model.entity.Location;
import model.entity.Weather;
import service.LocationService;
import service.WeatherService;
import validation.LocationValidate;

import java.util.Scanner;

public class UserInformation {
    private static final LocationService locationService = new LocationService();
    private static final LocationValidate locationValidate = new LocationValidate();
    private static final WeatherService weatherService = new WeatherService();


    public void initialInfo() {
        System.out.println("===== Weather Application =====");
    }

    public void options() {
        System.out.println("======================");
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


    public void displayWeather() {
        WeatherService weatherService = new WeatherService("src/main/resources/weatherFiles/locations.csv",
                "src/main/resources/weatherFiles/weather.csv");
        weatherService.getListOfWeatherToDisplay().forEach(System.out::println);
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

        }


    public void displayWeatherForEachCity() {
        System.out.println("Weather for each city: ");

        for (Weather w : weatherService.getListOfWeatherForEachCity()) {
            System.out.println("City: " + w.getLocation().getCity() + " Date: " + w.getDate()
                    + " Temperature: " + w.getTemperature()
                    + " Pressure: " + w.getPressure()
                    + " Humidity: " + w.getHumidity()
                    + " Wind with direction " + w.getWind()
            );
        }
    }
}
