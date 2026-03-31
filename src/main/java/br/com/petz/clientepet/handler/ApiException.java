package br.com.petz.clientepet.handler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@Slf4j
public class ApiException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String description;

    protected ApiException(HttpStatus statusException, String message, String description, Exception e) {
        super(message, e);
        this.httpStatus = statusException;
        this.description = description;
    }

    public ApiException(HttpStatus status, String message, String description) {
        super(message);
        this.httpStatus = status;
        this.description = description;
    }

}
