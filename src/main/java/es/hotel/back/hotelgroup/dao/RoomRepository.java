package es.hotel.back.hotelgroup.dao;

import es.hotel.back.hotelgroup.model.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository  extends JpaRepository<Room, Long>{
}
