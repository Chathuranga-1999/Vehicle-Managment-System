package com.vehicle_management.vehicle_service.controller;

import com.vehicle_management.vehicle_service.constants.VehicleConstants;
import com.vehicle_management.vehicle_service.exceptions.VehicleNotFoundException;
import com.vehicle_management.vehicle_service.model.Vehicle;
import com.vehicle_management.vehicle_service.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling API requests related to vehicles.
 * Provides endpoints for adding, retrieving, updating, and deleting vehicles.
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    /**
     * Constructs a {@link VehicleController} with the given {@link VehicleService}.
     *
     * @param vehicleService The service used to handle vehicle-related operations.
     */
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    /**
     * Endpoint to add a new vehicle.
     *
     * @param vehicle The vehicle object to be added.
     * @return The added vehicle entity.
     */
    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    /**
     * Endpoint to retrieve a list of available vehicles.
     *
     * @return A list of vehicles with status "Available".
     */
    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        return vehicleService.getAvailableVehicles();
    }

    /**
     * Endpoint to retrieve a list of vehicles that are not available.
     *
     * @return A list of vehicles with status "Not Available".
     */
    @GetMapping("/not-available")
    public List<Vehicle> getNotAvailableVehicles() {
        return vehicleService.getNotAvailableVehicles();
    }

    /**
     * Endpoint to delete a specific available vehicle by its ID.
     *
     * @param vehicleID The ID of the vehicle to be deleted.
     * @return A response entity containing a message about the deletion result.
     */
    @DeleteMapping("/available/delete/{vehicleID}")
    public ResponseEntity<String> deleteAvailableVehicle(@PathVariable Long vehicleID) {
        boolean isDeleted = vehicleService.deleteAvailableVehicle(vehicleID);
        if (isDeleted) {
            return new ResponseEntity<>(String.format(VehicleConstants.VEHICLE_DELETED_SUCCESS, vehicleID), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(String.format(VehicleConstants.VEHICLE_NOT_FOUND, vehicleID), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint to update an existing vehicle.
     *
     * @param vehicleID The ID of the vehicle to be updated.
     * @param vehicle The updated vehicle object.
     * @return The updated vehicle entity.
     */
    @PutMapping("/edit/{vehicleID}")
    public Vehicle updateVehicle(@PathVariable Long vehicleID, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vehicleID, vehicle);
    }

    /**
     * Handles exceptions of type {@link VehicleNotFoundException}.
     *
     * @param ex The exception to handle.
     * @return A response entity containing the exception message and a 404 status code.
     */
    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<String> handleVehicleNotFoundException(VehicleNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
