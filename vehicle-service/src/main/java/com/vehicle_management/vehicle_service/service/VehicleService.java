package com.vehicle_management.vehicle_service.service;

import com.vehicle_management.vehicle_service.model.Vehicle;

import java.util.List;

/**
 * Service interface for managing vehicle operations.
 */
public interface VehicleService {

    /**
     * Adds a new vehicle to the database.
     *
     * @param vehicle The vehicle to be added.
     * @return The saved vehicle entity.
     */
    Vehicle addVehicle(Vehicle vehicle);

    /**
     * Retrieves a list of available vehicles.
     *
     * @return A list of vehicles with status "Available".
     */
    List<Vehicle> getAvailableVehicles();

    /**
     * Retrieves a list of vehicles that are not available.
     *
     * @return A list of vehicles with status "Not Available".
     */
    List<Vehicle> getNotAvailableVehicles();

    /**
     * Updates an existing vehicle.
     *
     * @param vehicleID The ID of the vehicle to be updated.
     * @param vehicle The updated vehicle object.
     * @return The updated vehicle entity.
     */
    Vehicle updateVehicle(Long vehicleID, Vehicle vehicle);

    /**
     * Deletes a specific available vehicle by its ID.
     *
     * @param vehicleID The ID of the vehicle to be deleted.
     * @return True if the vehicle was deleted, false otherwise.
     */
    boolean deleteAvailableVehicle(Long vehicleID);
}
