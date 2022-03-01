package controller;

import model.Weather;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CsvWeatherLoaderTest {
    @Test
    void shouldLoadWeather() {
        CsvWeatherLoader csvWeatherLoader = new CsvWeatherLoader();
        List<Weather> result = csvWeatherLoader.read("src/test/resources/weatherFiles/weatherTest.csv");


        List<Weather> expectedResult = List.of(new Weather("KrakowTest","TemperatureTest",
                "pressureTest","humidityTest","windTest"));

        assertThat(result).hasSize(1)
                .isEqualTo(expectedResult);
    }

    @Test
    void shouldNotLoadWeather() {
        CsvWeatherLoader csvWeatherLoader = new CsvWeatherLoader();
        List<Weather> result = csvWeatherLoader.read("src/test/resources/weatherFiles/weatherTestEmptyFile.csv");

        assertThat(result).hasSize(0);
    }
}