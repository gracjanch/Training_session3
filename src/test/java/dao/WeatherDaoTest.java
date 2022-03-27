package dao;

import model.entity.Country;
import model.entity.Location;
import model.entity.Weather;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDaoTest {
    WeatherDao weatherDao = new WeatherDao();
    LocationDao locationDao = new LocationDao();

    Country testCountry = new Country("PL", "Polska");
    Location testLocation = new Location("WAR", "Warszawa", "80x80",
            "", testCountry);

    Date currentDate = new Date(Calendar.getInstance().getTime().getTime());

    Weather weatherTest = new Weather(9999, testLocation, "299",
            "9999", "99", "5.5", currentDate);


    //getAllWeathers
    @Test
    public void shouldGetAllWeathers() {
        List<Weather> allWeathers = weatherDao.getAllWeathers();

        Assert.assertNotNull(allWeathers);
    }


    //saveWeather
    @Test
    public void shouldSaveWeather() {
        locationDao.addLocation(testLocation);

        Integer sizeBeforeSave = weatherDao.getAllWeathers().size();

        weatherDao.saveWeather(weatherTest);

        Integer sizeAfterSave = weatherDao.getAllWeathers().size();

        Assert.assertTrue(sizeAfterSave == sizeBeforeSave + 1);

        Weather weatherToDelete = weatherDao.getAllWeathers()
                .get(weatherDao.getAllWeathers().size() - 1);

        weatherDao.deleteWeather(weatherToDelete);

        Location locationToDelete = locationDao.getAllLocations()
                .get(locationDao.getAllLocations().size() - 1);

        locationDao.deleteLocation(locationToDelete);
    }


    //weatherByCityNameAndDate
    @Test
    public void shouldReturnWeatherByCity() {
        locationDao.addLocation(testLocation);

        weatherDao.saveWeather(weatherTest);

        List<String> cityNameList = List.of(testLocation.getCity());
        List<Weather> result = weatherDao.weatherByCityNameAndDate(cityNameList);

        Assert.assertNotNull(result);

        Weather weatherToDelete = weatherDao.getAllWeathers()
                .get(weatherDao.getAllWeathers().size() - 1);

        weatherDao.deleteWeather(weatherToDelete);

        Location locationToDelete = locationDao.getAllLocations()
                .get(locationDao.getAllLocations().size() - 1);

        locationDao.deleteLocation(locationToDelete);
    }

}