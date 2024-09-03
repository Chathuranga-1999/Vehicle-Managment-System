package com.vehicle_management.vehicle_service.constants;

/**
 * Contains constants used across the vehicle management service.
 * This class centralizes the hard-coded strings and status values to ensure consistency.
 */
public class VehicleConstants {

    /**
     * Status indicating the vehicle is available for purchase or use.
     */
    public static final String STATUS_AVAILABLE = "Available";

    /**
     * Status indicating the vehicle is not available for purchase or use.
     */
    public static final String STATUS_NOT_AVAILABLE = "Not Available";

    /**
     * Message indicating the successful deletion of a vehicle.
     */
    public static final String VEHICLE_DELETED_SUCCESS = "Vehicle with ID %d has been successfully deleted.";

    /**
     * Message indicating that a vehicle was not found or is not available.
     */
    public static final String VEHICLE_NOT_FOUND = "Vehicle with ID %d not found or is not available.";

    /**
     * Message indicating that a vehicle was not found by its ID.
     */
    public static final String VEHICLE_NOT_FOUND_MSG = "Vehicle not found with ID: %d";
}
