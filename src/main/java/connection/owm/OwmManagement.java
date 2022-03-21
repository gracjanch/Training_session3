package connection.owm;

import dao.WeatherDao;
import model.entity.Location;
import model.entity.Weather;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class OwmManagement {
    private final Logger logger = LogManager.getLogger(OwmManagement.class);

    public Weather getWeatherForCity(Location location) {
        OWM owm = new OWM("f85b2eb3e2ade76bcb7e12953ba55c59");

        CurrentWeather cwd = null;
        Weather weather = new Weather();

        try {
            cwd = owm.currentWeatherByCityName(location.getCity() + ", " + location.getCountry().getCountryId());
        } catch (APIException e) {
            logger.error(e);
        }

        if(cwd == null) {
            return null;
        }

        if (cwd.hasRespCode() && cwd.getRespCode() == 200) {
            weather.setTemperature(cwd.getMainData().getTempMin() + "/" + cwd.getMainData().getTempMax());
            weather.setPressure(cwd.getMainData().getPressure().toString());
            weather.setHumidity(cwd.getMainData().getHumidity().toString());
            weather.setWind(cwd.getWindData().getSpeed().toString());
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            weather.setDate(Date.valueOf(s.format(cwd.getDateTime())));

            return weather;
        }
        return null;
    }
}
