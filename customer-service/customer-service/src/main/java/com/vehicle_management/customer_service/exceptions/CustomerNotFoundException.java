package com.vehicle_management.customer_service.exceptions;

/**
 * Exception thrown when a customer is not found in the system.
 * Extends {@link RuntimeException} to provide unchecked exception handling.
 */
public class CustomerNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@code CustomerNotFoundException} with the specified detail message.
     *
     * @param message the detail message which provides more information about the exception.
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
