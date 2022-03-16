import dao.CountryDao;
import dao.LocationDao;
import dao.WeatherDao;
import model.entity.Location;
import validation.LocationValidate;
import view.UserInformation;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {
    public static void main(String[] args) {
        Date data1 = new Date(Calendar.getInstance().getTime().getTime());
        WeatherDao weatherDao = new WeatherDao();

        List<Location> allLocation = new LocationDao().getAllLocations();
        for(Location l : allLocation){
            //System.out.println(l.getId());
            weatherDao.weatherByCityNameAndDate(l.getId(), data1.toString());
        }

    }
}
