package es.hotel.back.hotelgroup.api.controller;

import es.hotel.back.hotelgroup.api.ApiConstants;
import es.hotel.back.hotelgroup.model.api.RoomDto;
import es.hotel.back.hotelgroup.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(RoomController.BASE_MAPPING)
public class RoomController {
    static final String BASE_MAPPING = ApiConstants.API_BASE_PATH + "/rooms";
    private static final String ERROR = "Error {}";

    @Autowired
    private RoomService roomService;

    @ApiOperation(value = "Get all Rooms")
    @GetMapping
    public ResponseEntity<List<RoomDto>> getRooms() {
        try {
            return ResponseEntity.ok(roomService.getRooms());
        } catch (Exception e) {
            log.error(ERROR, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
