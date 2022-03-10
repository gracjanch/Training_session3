package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public abstract class CsvReader<T> {
    protected List<T> read(String path) {
        List<T> locations = new LinkedList<>();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(line -> locations.add(parseLine(line)));
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return locations;
    }

    protected abstract T parseLine(String line);
}
