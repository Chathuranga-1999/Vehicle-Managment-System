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
 * Provides the business logic for managing vehicles.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehicle> getAvailableVehicles() {
        return vehicleRepository.findByStatus(VehicleConstants.STATUS_AVAILABLE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vehicle> getNotAvailableVehicles() {
        return vehicleRepository.findByStatus(VehicleConstants.STATUS_NOT_AVAILABLE);
    }

    /**
     * {@inheritDoc}
     * @throws VehicleNotFoundException if the vehicle is not found by its ID.
     */
    @Override
    public Vehicle updateVehicle(Long vehicleID, Vehicle vehicle) {
        if (vehicleRepository.existsById(vehicleID)) {
            vehicle.setVehicleID(vehicleID);
            return vehicleRepository.save(vehicle);
        } else {
            throw new VehicleNotFoundException("Vehicle not found with ID: " + vehicleID);
        }
    }

    /**
     * {@inheritDoc}
     * @throws VehicleNotFoundException if the vehicle is not found or is not available.
     */
    @Override
    public boolean deleteAvailableVehicle(Long vehicleID) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleID);
        if (vehicleOptional.isPresent() && VehicleConstants.STATUS_AVAILABLE.equals(vehicleOptional.get().getStatus())) {
            vehicleRepository.deleteById(vehicleID);
            return true;
        } else {
            throw new VehicleNotFoundException("Vehicle not found or not available with ID: " + vehicleID);
        }
    }
}
