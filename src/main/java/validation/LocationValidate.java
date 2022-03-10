package validation;

import dao.CountryDao;
import dao.LocationDao;
import view.UserInformation;

import java.util.List;
import java.util.Scanner;
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

//        boolean properlyValue;
//        String cityLocation;
//        do {
//            cityLocation = new Scanner(System.in).nextLine();
//            Pattern nameCityPattern = Pattern.compile("[a-z]{2}+");
//            Matcher m = nameCityPattern.matcher(cityLocation);
//            properlyValue = m.find();
//            if (properlyValue) {
//                break;
//            }
//            System.out.println("Incorrect data. Write city name again.");
//        } while (!properlyValue);
//        return cityLocation;
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


//        boolean properlyValue;
//        String cityCoordinate;
//        boolean firstCoordBoolean = false;
//        boolean secondCoordBoolean = false;
//        do {
//
//            cityCoordinate = new Scanner(System.in).nextLine();
//            Pattern nameCityPattern = Pattern.compile("[-]*+[0-9]+[x]+[-]*[0-9]+");
//            Matcher m = nameCityPattern.matcher(cityCoordinate);
//            properlyValue = m.find();
//
//            if (!properlyValue) {
//                System.out.println("Incorrect data. Write coordinates again.");
//                continue;
//            }
//
//            String[] coordinates = cityCoordinate.split("x");
//            Integer firstCoord = Integer.valueOf(coordinates[0]);
//            Integer secondCoord = Integer.valueOf(coordinates[1]);
//            firstCoordBoolean = firstCoord >= -90 && firstCoord <= 90;
//            secondCoordBoolean = secondCoord >= -180 && secondCoord <= 180;
//
//            if (firstCoordBoolean && secondCoordBoolean) {
//                break;
//            }
//            System.out.println("Incorrect data. Write coordinates again.");
//        } while (!properlyValue && !firstCoordBoolean && !secondCoordBoolean);
//        return cityCoordinate;
    }

    public String validateCountryId() {
        CountryDao countryDao = new CountryDao();
        String value;
        boolean isValid = false;

        List<String> allCountriesId = countryDao.getAllCountriesId();

        do {
            boolean isCorrectlyWritten = false;
            boolean isAvailable = false;

            value = info.getInfoFromUser("Write country id (example: PL, GE): ");
            Pattern countryIdPattern = Pattern.compile("^[A-Z]{2}$");
            Matcher m = countryIdPattern.matcher(value);
            isCorrectlyWritten = m.find();

            if(allCountriesId.contains(value)) {
                isAvailable = true;
            } else {
                info.toUser("This country does not exist. Try again.");
            }

            if(isCorrectlyWritten && isAvailable) {
                isValid = true;
            }

        } while (!isValid);

        return value;
    }

    public String validateCityId() {
        LocationDao locationDao = new LocationDao();
        String value;
        boolean isValid = false;

        List<String> allCitiesId = locationDao.getAllCitiesId();

        do {
            boolean isCorrectlyWritten = false;
            boolean isAvailable = false;

            value = info.getInfoFromUser("Write city id (example: KRA, RZE): ");
            Pattern countryIdPattern = Pattern.compile("^[A-Z]{3}$");
            Matcher m = countryIdPattern.matcher(value);
            isCorrectlyWritten = m.find();

            if(!allCitiesId.contains(value)) {
                isAvailable = true;
            } else {
                info.toUser("This city already exists. Try again.");
            }

            if(isCorrectlyWritten && isAvailable) {
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
            if(value.equals("")) {
                return null;
            }
            Pattern coordinatesPattern = Pattern.compile("[A-Z]+[a-z]+");
            Matcher m = coordinatesPattern.matcher(value);
            isValid = m.find();
        } while (!isValid);

        return value;
    }


}
