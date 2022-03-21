package validation;

import dao.LocationDao;
import model.entity.Country;
import model.entity.Location;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LocationValidateTest {
    private final LocationValidate locationValidate = new LocationValidate();
    private final LocationDao locationDao = new LocationDao();
    private final Location location = Location.builder()
            .id("TES")
            .coordinates("55x55")
            .city("Test")
            .country(new Country("PL", "Poland"))
            .build();

    @Test
    void cityShouldBeValid() {
        String input = "Rzeszow";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(locationValidate.validateCityOrCountry("city"));
    }

    @Test
    void cityShouldNotBeValid() {
        String input = "rzeszow";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            locationValidate.validateCityOrCountry("city");
        }).isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");
    }

    @Test
    void coordinatesShouldBeValid() {
        String input = "33x33";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(locationValidate.validateCoordinates());
    }

    @Test
    void coordinatesShouldNotBeValid() {
        String input = "3333x44";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(locationValidate::validateCoordinates)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");
    }

    @Test
    void countryIdShouldBeValid() {
        String input = "PL";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(locationValidate.validateCountryId());
    }

    @Test
    void countryIdShouldNotBeValid() {
        String input = "pl";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(locationValidate::validateCountryId)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");
    }

    @Test
    void cityIdShouldBeValidOnAdding() {
        String input = "XXX";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(locationValidate.validateCityId("add"));
    }

    @Test
    void cityIdShouldNotBeValidOnAdding() {
        locationDao.addLocation(location);

        String input = "TES";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            locationValidate.validateCityId("add");
        })
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");

        locationDao.deleteLocation(location);
    }

    @Test
    void cityIdShouldBeValidOnDeleting() {
        locationDao.addLocation(location);

        String input = "TES";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(locationValidate.validateCityId("delete"));

        locationDao.deleteLocation(location);
    }

    @Test
    void cityIdShouldNotBeValidOnDeleting() {
        String input = "TES";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            locationValidate.validateCityId("delete");
        })
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");
    }

    @Test
    void regionShouldBeNull() {
        String input = "\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(locationValidate.validateRegion()).isNull();
    }

    @Test
    void regionShouldBeValid() {
        String input = "Region";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(locationValidate.validateRegion());
    }

    @Test
    void regionShouldNotBeValid() {
        String input = "region";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            locationValidate.validateCityId("delete");
        })
                .isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("No line found");
    }






}