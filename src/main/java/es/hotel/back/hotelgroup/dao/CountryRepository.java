package es.hotel.back.hotelgroup.dao;

import es.hotel.back.hotelgroup.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
