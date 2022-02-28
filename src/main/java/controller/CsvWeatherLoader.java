package controller;

import model.Location;
import model.Weather;

public class CsvWeatherLoader extends CsvReader<Weather>{
    @Override
    protected Weather parseLine(String line) {
        String[] values = line.split(",");
        Weather weather = new Weather();
        weather.setCityName(values[0]);
        weather.setTemperature(values[1]);
        weather.setPressure(values[2]);
        weather.setHumidity(values[3]);
        weather.setWind(values[4]);

        return weather;
    }
}
