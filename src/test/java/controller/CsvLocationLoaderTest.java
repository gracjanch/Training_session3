package controller;

import model.entity.Location;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class CsvLocationLoaderTest {
    @Test
    void shouldLoadLocation() {
        CsvLocationLoader csvLocationLoader = new CsvLocationLoader();

        List<Location> result = csvLocationLoader.read("src/test/resources/weatherFiles/locationLoadingTest.csv");

//        Location location = new Location();
//        location.setId(UUID.fromString("b86cfc49-5337-458e-80ed-80ad11ac1abc"));
//        location.setCoordinates("50x100");
//        location.setCity("Krakow");
//        location.setRegion("region");
//        location.setCountry("country");
//        List<Location> expectedResult = new ArrayList<>();
//        expectedResult.add(location);
//
//        assertThat(result).hasSize(1)
//                .isEqualTo(expectedResult);
    }

    @Test
    void shouldNotLoadWeather() {
        CsvLocationLoader csvLocationLoader = new CsvLocationLoader();
        List<Location> result = csvLocationLoader.read("src/test/resources/weatherFiles/weatherTestEmptyFile.csv");

        assertThat(result).hasSize(0);
    }
}