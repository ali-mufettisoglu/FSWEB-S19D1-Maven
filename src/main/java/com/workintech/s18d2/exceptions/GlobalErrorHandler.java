package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException plantException){
        log.error("Exception occured", plantException);
        PlantErrorResponse response = new PlantErrorResponse(plantException.getHttpStatus().value(),plantException.getMessage());
        return new ResponseEntity<>(response,plantException.getHttpStatus());
    }


    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception) {
        log.error("Exception occured", exception);
        PlantErrorResponse response = new PlantErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),exception.getMessage());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
