package es.hotel.back.hotelgroup.model.api;

import es.hotel.back.hotelgroup.common.model.ModelItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel("Model Country")
public class CountryDto extends ModelItem {

    @NotNull
    @ApiModelProperty(value = "the country's code", required = true)
    private String code;

    @NotNull
    @ApiModelProperty(value = "the country's name", required = true)
    private String name;
}
