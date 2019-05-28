package es.hotel.back.hotelgroup.service;

import es.hotel.back.hotelgroup.dao.CountryRepository;
import es.hotel.back.hotelgroup.model.api.CountryDto;
import es.hotel.back.hotelgroup.service.converter.CountryServiceConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository dao;

    @Autowired
    CountryServiceConverter converter;

    @Override
    public List<CountryDto> getCountries() {
        return dao.findAll().stream()
                .map(user -> converter.toApiModel(user, CountryDto.class))
                .collect(Collectors.toList());

    }
}
