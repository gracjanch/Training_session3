package validation;

import dao.CountryDao;
import dao.LocationDao;
import model.entity.Location;
import view.UserInformation;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocationValidate {
    private static final UserInformation info = new UserInformation();

    public String validateCityOrCountry(String cityOrCountry) {
        boolean isValid;
        String value;

        do {
            value = info.getInfoFromUser("Write " + cityOrCountry +
                    " (should begin with upper case letter and cannot be empty): ");
            Pattern cityOrCountryPattern = Pattern.compile("[A-Z][a-z]+");
            Matcher m = cityOrCountryPattern.matcher(value);
            isValid = m.find();
        } while (!isValid);

        return value;
    }


    public String validateCoordinates() {
        boolean isValid;
        String value;

        do {
            value = info.getInfoFromUser("Write coordinates (example: 40x100): ");
            Pattern coordinatesPattern = Pattern.compile("^[0-9]{1,3}x[0-9]{1,3}$");
            Matcher m = coordinatesPattern.matcher(value);
            isValid = m.find();
        } while (!isValid);

        return value;
    }

    public String validateCountryId() {
        CountryDao countryDao = new CountryDao();
        String value;
        boolean isValid = false;

        List<String> allCountriesId = countryDao.getAllCountriesId();

        do {
            boolean isCorrectlyWritten = false;
            boolean isAvailable = false;

            value = info.getInfoFromUser("Write country id (example: PL, DE): ");
            Pattern countryIdPattern = Pattern.compile("^[A-Z]{2}$");
            Matcher m = countryIdPattern.matcher(value);
            isCorrectlyWritten = m.find();

            if (allCountriesId.contains(value)) {
                isAvailable = true;
            } else {
                info.toUser("This country does not exist. Try again.");
            }

            if (isCorrectlyWritten && isAvailable) {
                isValid = true;
            }

        } while (!isValid);

        return value;
    }

    public String validateCityId(String addOrDelete) {
        LocationDao locationDao = new LocationDao();
        String value;
        boolean isValid = false;

        List<String> allCitiesId = locationDao.getAllLocations().stream().map(Location::getId).toList();

        do {
            boolean isCorrectlyWritten = false;
            boolean isAvailable = false;

            value = info.getInfoFromUser("Write city id (example: KRA, RZE): ");
            Pattern cityIdPattern = Pattern.compile("^[A-Z]{3}$");
            Matcher m = cityIdPattern.matcher(value);
            isCorrectlyWritten = m.find();

            if (addOrDelete.equals("add")) {
                if (!allCitiesId.contains(value)) {
                    isAvailable = true;
                } else {
                    info.toUser("This city already exists. Try again.");
                }
            } else {
                if (allCitiesId.contains(value)) {
                    isAvailable = true;
                } else {
                    info.toUser("This city does not exist. Try again.");
                }
            }

            if (isCorrectlyWritten && isAvailable) {
                isValid = true;
            }

        } while (!isValid);

        return value;
    }

    public String validateRegion() {
        boolean isValid;
        String value;

        do {
            value = info.getInfoFromUser("Write region (optional or " +
                    "should begin with upper case letter): ");
            if (value.equals("")) {
                return null;
            }
            Pattern regionPattern = Pattern.compile("[A-Z]+[a-z]+");
            Matcher m = regionPattern.matcher(value);
            isValid = m.find();
        } while (!isValid);

        return value;
    }


}
