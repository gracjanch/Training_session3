package service;

import connection.owm.OwmManagement;
import dao.WeatherDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.entity.Location;
import model.entity.Weather;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class WeatherService {
    private WeatherDao weatherDao;
    private OwmManagement owmManagement;

    public List<Weather> getWeatherFromDbOrDownloadForEachCity(){
        List<Location> allLocation = new LocationService().getListOfAllLocations();

        List<String> locationsIds = allLocation.stream()
                .map(Location::getId).toList();

        List<Weather> weathers = weatherDao.weatherByCityNameAndDate(locationsIds);

        List<String> citiesWithWeatherFromDataBase = weathers.stream().map(weather -> weather.getLocation().getId()).toList();

        for(Location location : allLocation) {
            if(!citiesWithWeatherFromDataBase.contains(location.getId())) {
                Weather weatherForCity = owmManagement.getWeatherForCity(location);
                if(weatherForCity != null) {
                    weatherForCity.setLocation(location);
                    weathers.add(weatherForCity);
                    weatherDao.saveWeather(weatherForCity);
                } else {
                    weathers.add(new Weather(null,location, "no data",
                            "no data", "no data", "no data", null ));
                }
            }
        }
        return weathers;
    }

}
