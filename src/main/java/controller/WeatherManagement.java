package controller;

import model.Location;
import model.Weather;

import java.util.LinkedList;
import java.util.List;

public class WeatherManagement {
    private final String path;

    public WeatherManagement(String path) {
        this.path = path;
    }

    private List<Weather> getListOfWeatherInEachCity() {
        CsvWeatherLoader csvWeatherLoader = new CsvWeatherLoader();
        return csvWeatherLoader.read(path)
                .stream()
                .filter(weather -> weather != null)
                .toList();
    }

    public List<Weather> getListOfWeatherToDisplay() {
        LocationManagement locationManagement = new LocationManagement("src/main/resources/weatherFiles/locations.csv");
        WeatherManagement weatherManagement = new WeatherManagement("src/main/resources/weatherFiles/weather.csv");

        List<Location> locations = locationManagement.getListOfAllLocations();
        List<Weather> weatherList = weatherManagement.getListOfWeatherInEachCity();

        List<Weather> weatherListToDisplay = new LinkedList<>();

        for(Location location : locations) {
            for(Weather weather : weatherList) {
                if(location.getCity().equals(weather.getCityName())) {
                    weatherListToDisplay.add(weather);
                }
            }
        }
        return weatherListToDisplay;
    }
}
