package controller;

import model.entity.Location;

import java.util.UUID;

public class CsvLocationLoader extends CsvReader<Location> {

    @Override
    protected Location parseLine(String line) {
        String[] values = line.split(",");
//        if(values.length == 5) {
//            Location location = new Location();
//            location.setId(UUID.fromString(values[0]));
//            location.setCoordinates(values[1]);
//            location.setCity(values[2]);
//            location.setRegion(values[3]);
//            location.setCountry(values[4]);
//            return location;
//        }
        return null;
    }
}
