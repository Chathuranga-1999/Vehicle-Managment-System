package com.vehicle_management.sales_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController; /**
 * Global exception handler for managing exceptions across the application.
 *
 * Catches exceptions thrown by controllers and returns appropriate HTTP responses.
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    /**
     * Handles SaleNotFoundException and returns a not found status with the error message.
     *
     * @param ex The exception to handle.
     * @return A ResponseEntity with the error message and HTTP status code 404.
     */
    @ExceptionHandler(SaleNotFoundException.class)
    public final ResponseEntity<String> handleSaleNotFoundException(SaleNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles general exceptions and returns a bad request status with a generic error message.
     *
     * @param ex The exception to handle.
     * @return A ResponseEntity with a generic error message and HTTP status code 400.
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
