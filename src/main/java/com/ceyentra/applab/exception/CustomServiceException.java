package com.ceyentra.applab.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomServiceException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public CustomServiceException(String message) {
        super(message);
        this.message = message;
    }

    public CustomServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public CustomServiceException(String message, HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
