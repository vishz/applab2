package com.ceyentra.applab.exception;

import com.ceyentra.applab.dto.ErrorMessageResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Log4j2
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorMessageResponse> handleAnyException(Exception ex, WebRequest webRequest) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorMessageResponse(false, "Something went wrong"), HttpStatus.OK);
    }

    @ExceptionHandler(value = {CustomServiceException.class})
    public ResponseEntity<ErrorMessageResponse> handleServiceException(CustomServiceException ex, WebRequest webRequest) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(value = {CustomOauthException.class})
    public ResponseEntity<ErrorMessageResponse> handleAuthenticationException(CustomOauthException ex, WebRequest webRequest) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorMessageResponse(false, ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public ResponseEntity<ErrorMessageResponse> handleAccessDeniedException(AccessDeniedException ex, WebRequest webRequest) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorMessageResponse(false, "Unauthorized request"), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<ErrorMessageResponse> handleUsernameNotFoundException(UsernameNotFoundException ex, WebRequest webRequest) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorMessageResponse(false, "User not found"), HttpStatus.UNAUTHORIZED);
    }
}
