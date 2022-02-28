package location;

import java.util.UUID;

import static location.LocationValidate.validCity;

public class Location {
    private UUID id;
    private String coordinates;
    private String city;
    private String region;
    private String country;

    public Location(String coordinates, String city, String region, String country) {
        this.id = gennerateUUID();
        this.coordinates = coordinates;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    private UUID gennerateUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", coordinates='" + coordinates + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public Location addLocation(){
        System.out.println("Write coordinates: (-90 -> 0 (S) 0 -> 90 (N))");
        String coordinates = "";
        System.out.println("Write city name: (cannot be empty)");
        //String city = validCity();
        String city = "";
        System.out.println("Write region: (optional)");
        String region = "";
        System.out.println("Write country name: (cannot be empty)");
        String country = "";
        return new Location(coordinates, city, region, country);
    }

}
