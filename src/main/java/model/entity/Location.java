package model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode
@Table(name = "cities")
public class Location {

    @Id
    @Column(name = "city_id")
    private String id;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "city_name")
    private String city;

    @Column(name = "region")
    private String region;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "location", fetch = FetchType.EAGER)
    private List<Weather> weathers;

    public Location(String id, String coordinates, String city, String region, Country country) {
        this.id = id;
        this.coordinates = coordinates;
        this.city = city;
        this.region = region;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country=" + country +
                '}';
    }
}
