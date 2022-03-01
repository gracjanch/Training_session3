package model;

public class Weather {
    private String cityName;
    private String temperature;
    private String pressure;
    private String humidity;
    private String wind;

    public Weather(String cityName, String temperature, String pressure, String humidity, String wind) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
    }

    public Weather() {
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cityName=" + cityName +
                ", temperature='" + temperature + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        if (cityName != null ? !cityName.equals(weather.cityName) : weather.cityName != null) return false;
        if (temperature != null ? !temperature.equals(weather.temperature) : weather.temperature != null) return false;
        if (pressure != null ? !pressure.equals(weather.pressure) : weather.pressure != null) return false;
        if (humidity != null ? !humidity.equals(weather.humidity) : weather.humidity != null) return false;
        return wind != null ? wind.equals(weather.wind) : weather.wind == null;
    }

    @Override
    public int hashCode() {
        int result = cityName != null ? cityName.hashCode() : 0;
        result = 31 * result + (temperature != null ? temperature.hashCode() : 0);
        result = 31 * result + (pressure != null ? pressure.hashCode() : 0);
        result = 31 * result + (humidity != null ? humidity.hashCode() : 0);
        result = 31 * result + (wind != null ? wind.hashCode() : 0);
        return result;
    }
}