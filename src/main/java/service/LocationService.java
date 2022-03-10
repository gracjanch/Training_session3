package service;

import loader.CsvLocationLoader;
import loader.CsvWriter;
import model.entity.Location;
import validation.LocationValidate;
import view.UserInformation;
import view.UserManagement;

import java.util.List;

public class LocationService {
    private final String path;

    public LocationService(String path) {
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

    public void addLocation() {
        UserInformation.addLocationMessages(0);
        String coordinates = LocationValidate.validCoordinate();
        UserInformation.addLocationMessages(1);;
        String city = LocationValidate.validCity();
        UserInformation.addLocationMessages(2);;
        String region = UserManagement.userChoice();
        UserInformation.addLocationMessages(3);;
        String country = LocationValidate.validCity();

        LocationService locationService = new LocationService("src/main/resources/weatherFiles/locations.csv");
        //locationManagement.addLocation(new Location(coordinates, city, region, country));
    }

}
