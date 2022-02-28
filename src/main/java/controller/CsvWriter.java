package controller;

import model.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CsvWriter {
    private static final String PATH = "src/main/resources/weatherFiles/locations.csv";
    public void write(Location location) {
        try {
            Files.write(Path.of(PATH), ((location.getId()+",").getBytes()), StandardOpenOption.APPEND);
            Files.write(Path.of(PATH), ((location.getCoordinates()+",").getBytes()), StandardOpenOption.APPEND);
            Files.write(Path.of(PATH), ((location.getCity()+",").getBytes()), StandardOpenOption.APPEND);
            Files.write(Path.of(PATH), (((location.getRegion()+",").getBytes())), StandardOpenOption.APPEND);
            Files.write(Path.of(PATH), (location.getCountry() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Unable to write the file.");
        }
    }
}
