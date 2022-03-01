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
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LocationManagementTest {
    @Test
    void shouldAddLocation() {
        String path = "src/test/resources/weatherFiles/locationTest.csv";

        LocationManagement locationManagement = new LocationManagement(path);
        locationManagement.addLocation(new Location("100x101", "city1", "region1","country1"));

        List<String> lines = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }

        String result = lines.get(lines.size() - 1);
        String expectedResult = "b86cfc49-5337-458e-80ed-80ad11ac1abc,100x100,Krakow,Region,Country";

        try {
            for (int i = 0; i <= lines.size() -2; i++) {
                Files.write(Path.of(path), (lines.get(i) + System.lineSeparator()).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.err.println("Unable to write the file.");
        }
    }
}