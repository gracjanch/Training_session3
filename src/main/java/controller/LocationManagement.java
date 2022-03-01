package controller;

import model.Location;
import view.UserInformation;

import java.util.List;
import java.util.stream.Collectors;

public class LocationManagement {
    private final String path;

    public LocationManagement(String path) {
        this.path = path;
    }

    public void addLocation(Location location) {
        CsvWriter csvWriter = new CsvWriter(path);
        csvWriter.write(location);
    }

    public List<Location> getListOfAllLocations(){
        CsvLocationLoader csvReader = new CsvLocationLoader();
        return csvReader.read(path)
                .stream()
                .filter(location -> location != null)
                .toList();
    }

    public static void addLocation() {
        UserInformation.addLocationMessages(0);
        String coordinates = LocationValidate.validCoordinate();
        UserInformation.addLocationMessages(1);;
        String city = LocationValidate.validCity();
        UserInformation.addLocationMessages(2);;
        String region = UserManagement.userChoice();
        UserInformation.addLocationMessages(3);;
        String country = LocationValidate.validCity();

        LocationManagement locationManagement = new LocationManagement();
        locationManagement.addLocation(new Location(coordinates, city, region, country));
    }

}
