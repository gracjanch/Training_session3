package model;

import controller.LocationManagement;
import controller.LocationValidate;
import controller.UserManagement;

import java.util.UUID;

public class Location {
    private UUID id;
    private String coordinates;
    private String city;
    private String region;
    private String country;

    public Location(String coordinates, String city, String region, String country) {
        this.id = UUID.randomUUID();
        this.coordinates = coordinates;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    public Location() {
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

    public static void addLocation() {
        System.out.println("Write coordinates: (example: 40x100)");
        String coordinates = LocationValidate.validCoordinate();
        System.out.println("Write city name: (cannot be empty)");
        String city = LocationValidate.validCity();
        System.out.println("Write region: (optional)");
        String region = UserManagement.userChoice();
        System.out.println("Write country name: (cannot be empty)");
        String country = LocationValidate.validCity();

        LocationManagement locationManagement = new LocationManagement();
        locationManagement.addLocation(new Location(coordinates, city, region, country));
    }

}
