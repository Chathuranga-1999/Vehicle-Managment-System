package com.vehicle_management.sales_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception for cases where a sale is not found in the system.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SaleNotFoundException extends RuntimeException {

    /**
     * Constructs a new SaleNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public SaleNotFoundException(String message) {
        super(message);
    }
}

