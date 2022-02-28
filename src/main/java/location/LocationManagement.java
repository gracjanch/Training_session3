package location;

import writer.CsvWriter;

public class LocationManagement {
    public void addLocation(Location location) {
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.write(location);
    }

}
