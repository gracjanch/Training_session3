package service;

import dao.WeatherDao;
import loader.CsvWeatherLoader;
import model.entity.Location;
import model.entity.Weather;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WeatherService {
    private static WeatherDao weatherDao = new WeatherDao();

//    private final String locationsPath;
//    private final String weatherPath;

    public List<Weather> getListOfWeatherForEachCity(){
        List<Weather> weathers = new ArrayList<>();
        List<Location> allLocation = new LocationService().getListOfAllLocations();
        for(Location l : allLocation){
            List<Weather> weathersDao = weatherDao.weatherByCityNameAndDate(l.getId());

            try {
                weathers.add(weathersDao.get(0));
            } catch (Exception e) {
                e.getMessage();
            }

        }
        return weathers;
    }



    public WeatherService(String locationsPath, String weatherPath) {
//        this.locationsPath = locationsPath;
//        this.weatherPath = weatherPath;
    }

//    private List<Weather> getListOfWeatherInEachCity() {
//        CsvWeatherLoader csvWeatherLoader = new CsvWeatherLoader();
//        return csvWeatherLoader.read(weatherPath)
//                .stream()
//                .filter(weather -> weather != null)
//                .toList();
//    }

    public List<Weather> getListOfWeatherToDisplay() {
//        LocationService locationService = new LocationService(locationsPath);
//
//        List<Location> locations = locationService.getListOfAllLocations();
//        List<Weather> weatherList = getListOfWeatherInEachCity();
//
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
