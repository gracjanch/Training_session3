package controller;

import model.entity.Location;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CsvWriter {
    private final String path;

    public CsvWriter(String path) {
        this.path = path;
    }

    public void write(Location location) {
        try {
            Files.write(Path.of(path), ((location.getId()+",").getBytes()), StandardOpenOption.APPEND);
            Files.write(Path.of(path), ((location.getCoordinates()+",").getBytes()), StandardOpenOption.APPEND);
            Files.write(Path.of(path), ((location.getCity()+",").getBytes()), StandardOpenOption.APPEND);
            Files.write(Path.of(path), (((location.getRegion()+",").getBytes())), StandardOpenOption.APPEND);
            Files.write(Path.of(path), (location.getCountry() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Unable to write the file.");
        }
    }
}
