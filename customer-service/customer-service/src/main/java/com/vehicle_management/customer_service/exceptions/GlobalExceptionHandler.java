package com.vehicle_management.customer_service.exceptions;

import com.vehicle_management.customer_service.constants.CustomerConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling exceptions across the entire application.
 * Provides specific exception handling for customer-related exceptions as well as general exceptions.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles CustomerNotFoundException and returns a 404 Not Found response.
     *
     * @param ex the CustomerNotFoundException that was thrown.
     * @return a ResponseEntity containing the exception message and a 404 status.
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles all other exceptions and returns a 500 Internal Server Error response.
     *
     * @param ex the Exception that was thrown.
     * @return a ResponseEntity containing the exception message and a 500 status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
