import location.Location;
import reader.CsvReader;
import userService.UserManagement;
import writer.CsvWriter;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        UserManagement userManagement = new UserManagement();
//        userManagement.start();
        CsvWriter csvWriter = new CsvWriter();
        Location location = new Location("50x100", "city", "region", "country");
        csvWriter.write(location);

        CsvReader csvReader = new CsvReader();
        List<Location> l = csvReader.read();

        l.stream().forEach(System.out::println);


    }
}
