package es.hotel.back.hotelgroup.api.controller;

import es.hotel.back.hotelgroup.api.ApiConstants;
import es.hotel.back.hotelgroup.exception.NotFoundException;
import es.hotel.back.hotelgroup.model.api.HotelDto;
import es.hotel.back.hotelgroup.model.filter.HotelFilter;
import es.hotel.back.hotelgroup.service.HotelService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(HotelController.BASE_MAPPING)
public class HotelController {

    static final String BASE_MAPPING = ApiConstants.API_BASE_PATH + "/hotels";
    private static final String HOTEL_MAPPING = "/{hotelId}";
    private static final String HOTEL_FILTER = "/filter";
    private static final String PAGEABLE_FILTER = "/lazy";
    private static final String ERROR = "Error {}";

    @Autowired
    private HotelService hotelService;

    @ApiOperation(value = "Get all hotels")
    @GetMapping
    public ResponseEntity<List<HotelDto>> getHotels() {
        try {
            return ResponseEntity.ok(hotelService.getHotels());
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Get all hotels pages")
    @GetMapping(HOTEL_FILTER + PAGEABLE_FILTER)
    public ResponseEntity<Page<HotelDto>> getHotelsPagination(Pageable pageable) {
        try {
            return ResponseEntity.ok(hotelService.getHotelsPagination(pageable));
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Create hotel")
    @PostMapping
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotel) {
        log.debug("hotel : {}", hotel);
        try {
            HotelDto hotelDto = hotelService.createHotel(hotel);
            return ResponseEntity.status(HttpStatus.CREATED).body(hotelDto);
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Get hotel by id")
    @GetMapping(HOTEL_MAPPING)
    public ResponseEntity<HotelDto> getHotel(@PathVariable Long hotelId) {
        log.debug("hotelId : {}", hotelId);
        try {
            Optional<HotelDto> hotelDto = hotelService.getHotel(hotelId);
            if (hotelDto.isPresent()) {
                return ResponseEntity.ok(hotelDto.get());
            } else {
                log.error("Hotel {} not found", hotelDto);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Update hotel by id")
    @PutMapping(HOTEL_MAPPING)
    public ResponseEntity updateUser(@RequestBody @Valid HotelDto hotelToPut, @PathVariable Long hotelId) {
        log.debug("userId: {} , userApi : {}", hotelId, hotelToPut);
        HotelDto hotelDto;
        try {
            hotelToPut.setId(hotelId);
            hotelDto = hotelService.updateUser(hotelToPut);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(hotelDto);
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @ApiOperation(value = "Delete hotel by id")
    @DeleteMapping(HOTEL_MAPPING)
    public ResponseEntity delete(@PathVariable Long hotelId) {
        log.debug("hotelId : {}", hotelId);
        try {
            hotelService.delete(hotelId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
