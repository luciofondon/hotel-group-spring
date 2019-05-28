package es.hotel.back.hotelgroup.service;

import es.hotel.back.hotelgroup.model.api.HotelDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HotelService {

     List<HotelDto> getHotels();

     Page<HotelDto> getHotelsPagination(Pageable pageable);

     Optional<HotelDto> getHotel(Long hotelId);

     HotelDto createHotel(HotelDto hotel);

     HotelDto updateUser(HotelDto hotelDto);

     void delete(Long hotelId);

}
