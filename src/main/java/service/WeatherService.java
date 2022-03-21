package service;

import connection.owm.OwmManagement;
import dao.WeatherDao;
import loader.CsvWeatherLoader;
import lombok.NoArgsConstructor;
import model.entity.Location;
import model.entity.Weather;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@NoArgsConstructor
public class WeatherService {
    private static WeatherDao weatherDao = new WeatherDao();
    private static OwmManagement owmManagement = new OwmManagement();

//    private final String locationsPath;
//    private final String weatherPath;

    public List<Weather> getListOfWeatherForEachCity(){
        List<Location> allLocation = new LocationService().getListOfAllLocations();
        List<Weather> weathers = new ArrayList<>();


        for(Location l : allLocation){
            if(weatherDao.isWeatherAvailable(l.getId())) {
                weathers.add(weatherDao.weatherByCityNameAndDate(l.getId()).get(0));
            } else {
                weathers.add(owmManagement.getWeatherForCity(l));
            }

        }
        return weathers;
    }

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
