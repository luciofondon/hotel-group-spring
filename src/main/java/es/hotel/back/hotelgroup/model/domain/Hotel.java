package es.hotel.back.hotelgroup.model.domain;

import es.hotel.back.hotelgroup.common.model.BaseEntity;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "HOTEL")
public class Hotel extends BaseEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STARS")
    private Integer stars;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="HOTEL_ID")
    private List<Room> rooms;
 }
