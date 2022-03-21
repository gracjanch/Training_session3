import connection.owm.OwmManagement;
import dao.LocationDao;
import dao.WeatherDao;
import model.entity.Location;
import model.entity.Weather;
import service.WeatherService;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        Date data1 = new Date(Calendar.getInstance().getTime().getTime());
        System.out.println(data1);

        LocationDao locationDao = new LocationDao();

        List<Location> allLocations = locationDao.getAllLocations();

        OwmManagement owmManagement = new OwmManagement();

        Weather weatherForCity = owmManagement.getWeatherForCity(allLocations.get(0));

        System.out.println(weatherForCity);

    }
}
