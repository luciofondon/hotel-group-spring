package es.hotel.back.hotelgroup.service.converter;

import es.hotel.back.hotelgroup.common.converter.AbstractModelConverter;
import es.hotel.back.hotelgroup.model.api.RoomDto;
import es.hotel.back.hotelgroup.model.domain.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomServiceConverter extends AbstractModelConverter<RoomDto, Room> {

}
