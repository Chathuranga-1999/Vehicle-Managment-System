package com.Vehicle_management_system.service_record_service.exception;

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