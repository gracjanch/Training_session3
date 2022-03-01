package controller;

import model.Location;
import model.Weather;

import java.util.LinkedList;
import java.util.List;

public class WeatherManagement {
    public List<Weather> getListOfWeatherInEachCity() {
        CsvWeatherLoader csvWeatherLoader = new CsvWeatherLoader();
        return csvWeatherLoader.read("src/main/resources/weatherFiles/weather.csv")
                .stream()
                .filter(weather -> weather != null)
                .toList();
    }

    public List<Weather> getListOfWeatherToDisplay() {
        LocationManagement locationManagement = new LocationManagement();
        WeatherManagement weatherManagement = new WeatherManagement();

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
