package view;


import connection.owm.OwmManagement;
import dao.LocationDao;
import dao.WeatherDao;
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
    private static final WeatherService weatherService = new WeatherService(new WeatherDao(), new OwmManagement());


    public void initialInfo() {
        System.out.println("===============================");
        System.out.println("===== Weather Application =====");
    }

    public void options() {
        System.out.println("===============================");
        System.out.println("[1] - Add location.");
        System.out.println("[2] - Update location.");
        System.out.println("[3] - Delete location.");
        System.out.println("[4] - Display all locations.");
        System.out.println("[5] - Show weather.");
        System.out.println("[6] - Quit.");
    }

    public void toUser(String info) {
        System.out.println(info);
    }

    public String getInfoFromUser(String infoToUser) {
        System.out.print(infoToUser);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void displayAllLocations() {
        System.out.println("List of all locations: ");
        locationService.getListOfAllLocations()
                .forEach(System.out::println);
    }

    public void addLocation() {
        Location location = Location.builder()
                .id(locationValidate.validateCityId("add"))
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

        for (Weather w : weatherService.getWeatherFromDbOrDownloadForEachCity()) {
            if (w.getWeatherId() != null) {
                System.out.println("City: " + w.getLocation().getCity() + "  Date: " + w.getDate() + ", "
                        + " Temperature (min/max): " + w.getTemperature() + " " + (char) (176) + "C, "
                        + " Pressure: " + w.getPressure() + " MPa, "
                        + " Humidity: " + w.getHumidity() + "%, "
                        + " Wind: " + w.getWind() + " km/h"
                );
            } else {
                System.out.println("City: " + w.getLocation().getCity() + "  NO DATA");
            }
        }
    }

    public void deleteLocation() {
        LocationDao locationDao = new LocationDao();
        Location location = locationDao.findById(locationValidate.validateCityId("delete"));

        locationService.deleteLocation(location);
    }

    public void updateLocation() {
        LocationDao locationDao = new LocationDao();
        Country country = new Country();
        Location location = locationDao.findById(locationValidate.validateCityId("delete"));


        location.setId(getInfoFromUser("Type new city id: (Before: "
                + location.getId() + ")"));

        System.out.print("(Before " + location.getCoordinates() + "). ");
        location.setCoordinates(locationValidate.validateCoordinates());

        System.out.print("(Before " + location.getCity() + "). ");
        location.setCity(locationValidate.validateCityOrCountry("city name"));

        System.out.print("(Before " + location.getRegion() + "). ");
        location.setRegion(locationValidate.validateRegion());

        System.out.print("(Before " + location.getCountry().getCountryId() + "). ");
        country.setCountryId(getInfoFromUser("Type country id (example PL,DE)"));

        System.out.print("(Before " + location.getCountry().getCountryName() + "). ");
        country.setCountryName(locationValidate.validateCityOrCountry("country name"));

        location.setCountry(country);

        locationService.updateLocation(location);
    }

}
