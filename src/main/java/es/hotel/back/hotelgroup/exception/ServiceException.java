package es.hotel.back.hotelgroup.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceException extends Exception {

    private final String code;
    private final HttpStatus httpStatus;

    public ServiceException(String code, HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.httpStatus = httpStatus;
    }

}
