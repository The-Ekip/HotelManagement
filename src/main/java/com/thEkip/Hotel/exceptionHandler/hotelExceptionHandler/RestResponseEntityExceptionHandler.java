package com.thEkip.Hotel.exceptionHandler.hotelExceptionHandler;

import com.thEkip.Hotel.exceptionHandler.hotelExceptions.BusinessRuleException;
import com.thEkip.Hotel.exceptionHandler.hotelExceptions.EntityNotFoundException;
import com.thEkip.Hotel.utilities.response.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@link https://www.baeldung.com/exception-handling-for-rest-with-spring
@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = { EntityNotFoundException.class, EntityNotFoundException.class })
    protected ResponseEntity<Object> handleEntityNotFoundConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getLocalizedMessage();
        return ResponseEntity.badRequest().body(new ErrorResponse(bodyOfResponse));
    }

    @ExceptionHandler(value = { BusinessRuleException.class, BusinessRuleException.class })
    protected ResponseEntity<Object> handleBusinessRuleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getLocalizedMessage();
        return ResponseEntity.badRequest().body(new ErrorResponse(bodyOfResponse));
    }
}