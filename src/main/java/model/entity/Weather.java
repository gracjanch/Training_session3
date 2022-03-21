package model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@EqualsAndHashCode
@Table(name = "weather_for_each_city")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_for_each_city_generator")
    //@SequenceGenerator(name="persons_generator", sequenceName = "persons_person_id_seq",allocationSize = 1)
    @Column(name = "weather_id")
    private Integer weatherId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private Location location;

    @Column(name = "temperature")
    private String temperature;

    @Column(name = "pressure")
    private String pressure;

    @Column(name = "humidity")
    private String humidity;

    @Column(name = "wind")
    private String wind;

    @Column(name = "date")
    private Date date;
}