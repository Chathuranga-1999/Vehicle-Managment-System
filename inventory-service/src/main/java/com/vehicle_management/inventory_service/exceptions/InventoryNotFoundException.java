package com.vehicle_management.inventory_service.exceptions;

/**
 * Custom exception to be thrown when an inventory part is not found.
 * Extends RuntimeException to provide unchecked exception behavior.
 */
public class InventoryNotFoundException extends RuntimeException {

    /**
     * Constructs a new InventoryNotFoundException with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InventoryNotFoundException(String message) {
        super(message);
    }
}
