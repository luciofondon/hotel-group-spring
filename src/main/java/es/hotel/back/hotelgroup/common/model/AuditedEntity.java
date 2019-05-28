package es.hotel.back.hotelgroup.common.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class AuditedEntity extends BaseEntity {

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @Column(name = "MODIFICATION_DATE")
    private LocalDateTime modificationDate;

    @Column(name = "DISABLE_DATE")
    private LocalDate disableDate;

}
