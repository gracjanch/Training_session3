import location.Location;
import reader.CsvReader;
import userService.UserManagement;
import writer.CsvWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserManagement userManagement = new UserManagement();
        userManagement.start();
    }
}
