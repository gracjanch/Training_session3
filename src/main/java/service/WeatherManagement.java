package service;

import loader.CsvWeatherLoader;
import model.entity.Location;
import model.entity.Weather;
import service.LocationService;

import java.util.LinkedList;
import java.util.List;

public class WeatherManagement {
    private final String locationsPath;
    private final String weatherPath;

    public WeatherManagement(String locationsPath, String weatherPath) {
        this.locationsPath = locationsPath;
        this.weatherPath = weatherPath;
    }

    private List<Weather> getListOfWeatherInEachCity() {
        CsvWeatherLoader csvWeatherLoader = new CsvWeatherLoader();
        return csvWeatherLoader.read(weatherPath)
                .stream()
                .filter(weather -> weather != null)
                .toList();
    }

    public List<Weather> getListOfWeatherToDisplay() {
        LocationService locationService = new LocationService(locationsPath);

        List<Location> locations = locationService.getListOfAllLocations();
        List<Weather> weatherList = getListOfWeatherInEachCity();

        List<Weather> weatherListToDisplay = new LinkedList<>();

//        for(Location location : locations) {
//            for(Weather weather : weatherList) {
//                if(location.getCity().equals(weather.getCityName())) {
//                    weatherListToDisplay.add(weather);
//                }
//            }
//        }
        return weatherListToDisplay;
    }
}
