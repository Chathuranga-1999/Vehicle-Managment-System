package com.vehicle_management.vehicle_service.service.impl;

import com.vehicle_management.vehicle_service.constants.VehicleConstants;
import com.vehicle_management.vehicle_service.exceptions.VehicleNotFoundException;
import com.vehicle_management.vehicle_service.model.Vehicle;
import com.vehicle_management.vehicle_service.repository.VehicleRepository;
import com.vehicle_management.vehicle_service.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link VehicleService} interface.
 * Provides the business logic for managing vehicles including adding, updating, and deleting vehicles.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * {@inheritDoc}
     * Adds a new vehicle to the repository.
     *
     * @param vehicle The vehicle object to be added.
     * @return The added vehicle entity.
     */
    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * {@inheritDoc}
     * Retrieves a list of vehicles that are available.
     *
     * @return A list of vehicles with status "Available".
     */
    @Override
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByStatus(VehicleConstants.STATUS_AVAILABLE);
    }

    /**
     * {@inheritDoc}
     * Retrieves a list of vehicles that are not available.
     *
     * @return A list of vehicles with status "Not Available".
     */
    @Override
    public List<Vehicle> getNotAvailableVehicles() {
        return vehicleRepository.findByStatus(VehicleConstants.STATUS_NOT_AVAILABLE);
    }

    /**
     * {@inheritDoc}
     * Updates an existing vehicle identified by its ID.
     *
     * @param vehicleID The ID of the vehicle to be updated.
     * @param vehicle The updated vehicle object.
     * @return The updated vehicle entity.
     * @throws VehicleNotFoundException if the vehicle is not found by its ID.
     */
    @Override
    public Vehicle updateVehicle(Long vehicleID, Vehicle vehicle) {
        if (vehicleRepository.existsById(vehicleID)) {
            vehicle.setVehicleID(vehicleID);
            return vehicleRepository.save(vehicle);
        } else {
            throw new VehicleNotFoundException(String.format(VehicleConstants.VEHICLE_NOT_FOUND_MSG, vehicleID));
        }
    }

    /**
     * {@inheritDoc}
     * Deletes a vehicle that is available and identified by its ID.
     *
     * @param vehicleID The ID of the vehicle to be deleted.
     * @return True if the vehicle was deleted successfully, false otherwise.
     * @throws VehicleNotFoundException if the vehicle is not found or is not available.
     */
    @Override
    public boolean deleteAvailableVehicle(Long vehicleID) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleID);
        if (vehicleOptional.isPresent() && VehicleConstants.STATUS_AVAILABLE.equals(vehicleOptional.get().getStatus())) {
            vehicleRepository.deleteById(vehicleID);
            return true;
        } else {
            throw new VehicleNotFoundException(String.format(VehicleConstants.VEHICLE_NOT_FOUND, vehicleID));
        }
    }
}
