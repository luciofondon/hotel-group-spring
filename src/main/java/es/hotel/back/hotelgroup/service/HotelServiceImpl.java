package es.hotel.back.hotelgroup.service;

import es.hotel.back.hotelgroup.dao.HotelRepository;
import es.hotel.back.hotelgroup.model.api.HotelDto;
import es.hotel.back.hotelgroup.model.domain.Hotel;
import es.hotel.back.hotelgroup.model.filter.HotelFilter;
import es.hotel.back.hotelgroup.service.converter.HotelServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelServiceImpl implements HotelService{

    @Autowired
    HotelRepository dao;

    @Autowired
    HotelServiceConverter converter;

    @Override
    public List<HotelDto> getHotels() {
        return dao.findAll().stream()
                .map(user -> converter.toApiModel(user, HotelDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<HotelDto> getHotelsPagination(Pageable pageable) {
        return dao.findAll(pageable).map(hotel -> converter.toApiModel(hotel, HotelDto.class));
    }

    @Override
    public Optional<HotelDto> getHotel(Long hotelId) {
        return dao.findById(hotelId)
                .map(userFromBd -> converter.toApiModel(userFromBd, HotelDto.class));
    }

    @Override
    public HotelDto createHotel(HotelDto hotelDto){
        Hotel hotel = converter.toDomainModel(hotelDto, Hotel.class);
        hotel.setId(null);
        hotel = dao.save(hotel);

        return converter.toApiModel(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateUser(HotelDto hotelDto) {
        Hotel user = converter.toDomainModel(hotelDto, Hotel.class);
        dao.save(user);
        return hotelDto;
    }

    @Override
    public void delete(Long hotelId) {
        dao.deleteById(hotelId);
    }

}
