package es.hotel.back.hotelgroup.dao;

import es.hotel.back.hotelgroup.model.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{
}
