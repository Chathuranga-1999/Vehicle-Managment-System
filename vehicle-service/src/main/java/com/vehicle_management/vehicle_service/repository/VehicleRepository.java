package com.vehicle_management.vehicle_service.repository;

import com.vehicle_management.vehicle_service.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing and managing {@link Vehicle} entities.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    /**
     * Retrieves a list of vehicles based on their status.
     *
     * @param status The status of the vehicles to retrieve (e.g., "Available", "Not Available").
     * @return A list of vehicles with the specified status.
     */
    List<Vehicle> findByStatus(String status);
}
