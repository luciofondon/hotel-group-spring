package es.hotel.back.hotelgroup.service;

import es.hotel.back.hotelgroup.model.api.RoomDto;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<RoomDto> getRooms();

    Optional<RoomDto> getRoom(Long roomId);

}
