package service;

import dao.LocationDao;
import loader.CsvLocationLoader;
import loader.CsvWriter;
import model.entity.Location;
import validation.LocationValidate;
import view.UserInformation;
import view.UserManagement;

import java.util.List;

public class LocationService {
    private static LocationDao locationDao = new LocationDao();
    //private final String path;

//    public LocationService(String path) {
//        this.path = path;
//    }

    public void addLocation(Location location) {
        locationDao.addLocation(location);
    }

    public List<Location> getListOfAllLocations(){
        LocationDao locationDao = new LocationDao();
        return locationDao.getAllLocations();
    }
}
