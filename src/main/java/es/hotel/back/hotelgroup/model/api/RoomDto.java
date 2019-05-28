package es.hotel.back.hotelgroup.model.api;

import es.hotel.back.hotelgroup.common.model.ModelItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Model Room")
public class RoomDto extends ModelItem {

    @NotNull
    @ApiModelProperty(value = "the room's number", required = true)
    private Integer number;

    @NotNull
    @ApiModelProperty(value = "the room's checkin", required = true)
    private Boolean checkin;

    @NotNull
    @ApiModelProperty(value = "the room's doubleBed", required = true)
    private Boolean doubleBed;

    @NotNull
    @ApiModelProperty(value = "the room's cleaning", required = true)
    private Boolean cleaning;

    @ApiModelProperty(value = "the room's hotel", required = true)
    private HotelDto hotel;
}
