package es.hotel.back.hotelgroup.model.domain;

import es.hotel.back.hotelgroup.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ROOM")
public class Room extends BaseEntity {

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "CHECKIN")
    private Boolean checkin;

    @Column(name = "DOUBLE_BED")
    private Boolean doubleBed;

    @Column(name = "CLEANING")
    private Boolean cleaning;

    @ManyToOne
    @JoinColumn(name="HOTEL_ID")
    private Hotel hotel;
}
