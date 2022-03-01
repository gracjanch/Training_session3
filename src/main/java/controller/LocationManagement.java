package controller;

import model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationManagement {
    private final String path;

    public LocationManagement(String path) {
        this.path = path;
    }

    public void addLocation(Location location) {
        CsvWriter csvWriter = new CsvWriter("src/main/resources/weatherFiles/locations.csv");
        csvWriter.write(location);
    }

    public List<Location> getListOfAllLocations(){
        CsvLocationLoader csvReader = new CsvLocationLoader();
        return csvReader.read(path)
                .stream()
                .filter(location -> location != null)
                .toList();
    }

}
