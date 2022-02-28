package controller;

import model.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public abstract class CsvReader {
    private static final String PATH = "src/main/resources/weatherFiles/locations.csv";

    protected List<Location> read() {
        List<Location> locations = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(PATH))) {
            stream.forEach(line -> locations.add(parseLine(line)));
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return locations;
    }

    protected abstract Location parseLine(String line);

}
