package dao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CountryDaoTest {
    CountryDao countryDao = new CountryDao();
    List<String> countryIDs = countryDao.getAllCountriesId();

    @Test
    public void shouldCheckNotNull(){
        Assert.assertNotNull(countryIDs);
    }

    @Test
    public void shouldCheckCountryIdIsIn(){
        Assert.assertTrue(countryIDs.contains("PL"));
    }

    @Test
    public void shouldCheckCountryIdIsNotIn(){
        Assert.assertFalse(countryIDs.contains("GB"));
    }
}