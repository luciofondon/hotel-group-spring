package es.hotel.back.hotelgroup.service;


import es.hotel.back.hotelgroup.dao.RoomRepository;
import es.hotel.back.hotelgroup.model.api.CountryDto;
import es.hotel.back.hotelgroup.model.api.RoomDto;
import es.hotel.back.hotelgroup.model.domain.Room;
import es.hotel.back.hotelgroup.service.converter.RoomServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService{

    @Autowired
    RoomRepository dao;

    @Autowired
    RoomServiceConverter converter;


    @Override
    public List<RoomDto> getRooms() {
        return dao.findAll().stream()
                .map(user -> converter.toApiModel(user, RoomDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RoomDto> getRoom(Long roomId) {
        return dao.findById(roomId)
                .map(userFromBd -> converter.toApiModel(userFromBd, RoomDto.class));
    }


}
