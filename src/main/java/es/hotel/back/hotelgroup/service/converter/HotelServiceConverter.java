package es.hotel.back.hotelgroup.service.converter;

import es.hotel.back.hotelgroup.common.converter.AbstractModelConverter;
import es.hotel.back.hotelgroup.model.api.HotelDto;
import es.hotel.back.hotelgroup.model.domain.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelServiceConverter extends AbstractModelConverter<HotelDto, Hotel> {

}
