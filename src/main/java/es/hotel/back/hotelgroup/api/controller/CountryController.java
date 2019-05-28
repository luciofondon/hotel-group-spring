package es.hotel.back.hotelgroup.api.controller;

import es.hotel.back.hotelgroup.api.ApiConstants;
import es.hotel.back.hotelgroup.model.api.CountryDto;
import es.hotel.back.hotelgroup.service.CountryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(CountryController.BASE_MAPPING)
public class CountryController {
    static final String BASE_MAPPING = ApiConstants.API_BASE_PATH + "/countries";
    private static final String ERROR = "Error {}";

    @Autowired
    private CountryService countryService;

    @ApiOperation(value = "Get al countries")
    @GetMapping
    public ResponseEntity<List<CountryDto>> findAll() {
        try {
            return ResponseEntity.ok(countryService.getCountries());
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
