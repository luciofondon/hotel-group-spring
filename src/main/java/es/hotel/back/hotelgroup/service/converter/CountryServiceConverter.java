package es.hotel.back.hotelgroup.service.converter;

import es.hotel.back.hotelgroup.common.converter.AbstractModelConverter;
import es.hotel.back.hotelgroup.model.api.CountryDto;
import es.hotel.back.hotelgroup.model.domain.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryServiceConverter extends AbstractModelConverter<CountryDto, Country> {

}