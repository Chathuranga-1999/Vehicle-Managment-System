package com.vehicle_management.vehicle_service.exceptions;

/**
 * Exception thrown when a vehicle is not found in the database.
 */
public class VehicleNotFoundException extends RuntimeException {

    /**
     * Constructs a new VehicleNotFoundException with the specified detail message.
     *
     * @param message The detail message.
     */
    public VehicleNotFoundException(String message) {
        super(message);
    }
}
