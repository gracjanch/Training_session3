
import dao.LocationDao;
import dao.WeatherDao;
import model.entity.Location;




import java.util.List;


public class MainTest {
    public static void main(String[] args) {

        WeatherDao weatherDao = new WeatherDao();

        List<Location> allLocation = new LocationDao().getAllLocations();
        for(Location l : allLocation){

            weatherDao.weatherByCityNameAndDate(l.getId());
        }

    }
}
