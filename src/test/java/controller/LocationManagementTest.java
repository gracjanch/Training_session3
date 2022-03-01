package controller;

import model.Location;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class LocationManagementTest {
    @Test
    void shouldAddLocation() {
        String path = "src/test/resources/weatherFiles/locationTest.csv";

        LocationManagement locationManagement = new LocationManagement(path);
        Location location = new Location("100x101", "city1", "region1","country1");
        locationManagement.addLocation(location);

        List<String> lines = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

        String[] result = lines.get(lines.size() - 1).split(",");

        try {
            for (int i = 0; i <= lines.size() -2; i++) {
                Files.write(Path.of(path), (lines.get(i) + System.lineSeparator()).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.err.println("Unable to write the file.");
        }

        assertThat(UUID.fromString(result[0])).isEqualTo(location.getId());
        assertThat(result[1]).isEqualTo(location.getCoordinates());
        assertThat(result[2]).isEqualTo(location.getCity());
        assertThat(result[3]).isEqualTo(location.getRegion());
        assertThat(result[4]).isEqualTo(location.getCountry());
    }
}