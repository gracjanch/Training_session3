package model.entity;

import lombok.*;

import javax.persistence.*;
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
}
