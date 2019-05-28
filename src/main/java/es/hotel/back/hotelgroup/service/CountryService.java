package es.hotel.back.hotelgroup.service;

import es.hotel.back.hotelgroup.model.api.CountryDto;

import java.util.List;

public interface CountryService {

    List<CountryDto> getCountries();

}
