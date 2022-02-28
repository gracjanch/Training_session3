package controller;

import model.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class CsvReader {
    private static final String PATH = "src/main/resources/weatherFiles/locations.csv";

    public List<Location> read() {
        List<Location> locations = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(PATH))) {
            stream.forEach(line -> locations.add(parseLine(line)));
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return locations;
    }

    private Location parseLine(String line) {
        String[] values = line.split(",");
        Location location = new Location();
        location.setId(UUID.fromString(values[0]));
        location.setCoordinates(values[1]);
        location.setCity(values[2]);
        location.setRegion(values[3]);
        location.setCountry(values[4]);
        return location;
    }

}
