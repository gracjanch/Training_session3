import controller.UserManagement;
import controller.dao.CountryDao;

public class Main {
    public static void main(String[] args) {
        //UserManagement userManagement = new UserManagement();
        //userManagement.start();

        CountryDao countryDao = new CountryDao();
        countryDao.displayAllCountries("PL");
    }
}
