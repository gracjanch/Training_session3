package controller;

import model.entity.Weather;
import org.junit.jupiter.api.Test;
import service.WeatherManagement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherManagementTest {
    @Test
    void shouldReturnListWithoutNull() {
        WeatherManagement weatherManagement = new WeatherManagement("src/test/resources/weatherFiles/locationTest.csv",
                "src/test/resources/weatherFiles/weatherTest.csv");

        List<Weather> result = weatherManagement.getListOfWeatherToDisplay();

        assertThat(result).doesNotContainNull();
    }

}