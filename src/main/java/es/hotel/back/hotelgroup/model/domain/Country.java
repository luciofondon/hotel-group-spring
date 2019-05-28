package es.hotel.back.hotelgroup.model.domain;

import es.hotel.back.hotelgroup.common.model.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COUNTRY")
public class Country extends BaseEntity {

    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

}
