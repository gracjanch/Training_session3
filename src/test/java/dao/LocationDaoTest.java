package dao;

import model.entity.Country;
import model.entity.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationDaoTest {
    private static final Logger logger = LogManager.getLogger(LocationDaoTest.class);

    private LocationDao locationDao;

    Country testCountry = new Country("PL", "Polska");
    Location testLocation = new Location("WAR", "Warszawa", "80x80",
            "", testCountry);


    //addLocation
    @Test
    public void shouldAddLocation() {

        LocationDao resultLocationDao = new LocationDao();

        resultLocationDao.addLocation(testLocation);

        Assert.assertNotNull(resultLocationDao.getAllLocations());

        resultLocationDao.deleteLocation(testLocation);
    }


    //findById
    @Test
    public void shouldFindLocationById() {
        LocationDao resultLocationDao = new LocationDao();
        Location locationResult = resultLocationDao.findById("KRA");
        Assert.assertEquals(locationResult.getCity(), "Kraków");
    }


    //getAllLocation
    @Test
    public void shouldCheckGetAllLocations() {
        LocationDao resultLocationDao = new LocationDao();
        List<Location> listResult = resultLocationDao.getAllLocations();
        Assert.assertNotNull(listResult);
    }


    //deleteLocation
    @Test
    public void shouldDeleteLocation() {
        LocationDao resultLocationDao = new LocationDao();

        resultLocationDao.addLocation(testLocation);

        Location result = resultLocationDao.findById("WAR");

        int sizeBeforeDelete = resultLocationDao.getAllLocations().size();

        resultLocationDao.deleteLocation(result);

        int sizeAfterDelete = resultLocationDao.getAllLocations().size();

        Assert.assertTrue(sizeBeforeDelete == sizeAfterDelete + 1);
    }

    @Test
    public void shouldUpdateLocation(){
        LocationDao resultLocationDao = new LocationDao();

        resultLocationDao.addLocation(testLocation);

        Location locationToUpdate = resultLocationDao.findById("WAR");

        locationToUpdate.setCity("Toruń");

        resultLocationDao.updateLocation(locationToUpdate);

        String cityAfterUpdate = resultLocationDao.findById("WAR").getCity();

        Assert.assertEquals("Toruń", cityAfterUpdate);

        resultLocationDao.deleteLocation(locationToUpdate);

    }

}