package controller;

import model.Location;

import java.util.List;
import java.util.stream.Collectors;

public class LocationManagement {
    public void addLocation(Location location) {
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(location);
    }

    public List<Location> getListOfAllLocations(){
        CsvLocationLoader csvReader = new CsvLocationLoader();
        return csvReader.read("src/main/resources/weatherFiles/locations.csv")
                .stream()
                .filter(location -> location != null)
                .toList();
    }

}
