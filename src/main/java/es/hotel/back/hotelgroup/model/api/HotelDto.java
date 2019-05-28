package es.hotel.back.hotelgroup.model.api;

import es.hotel.back.hotelgroup.common.model.ModelItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("Model Hotel")
public class HotelDto extends ModelItem {

    @Id
    @ApiModelProperty(value = "the hotel's id", required = true)
    private Long id;

    @NotNull
    @ApiModelProperty(value = "the hotel's name", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "the hotel's address", required = true)
    private String address;

    @NotNull
    @ApiModelProperty(value = "the hotel's description", required = true)
    private String description;

    @ApiModelProperty(value = "the hotel's stars", required = true)
    private Integer stars;

}
