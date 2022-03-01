package model;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (id != null ? !id.equals(location.id) : location.id != null) return false;
        if (coordinates != null ? !coordinates.equals(location.coordinates) : location.coordinates != null)
            return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (region != null ? !region.equals(location.region) : location.region != null) return false;
        return country != null ? country.equals(location.country) : location.country == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public Location addLocation() {
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
