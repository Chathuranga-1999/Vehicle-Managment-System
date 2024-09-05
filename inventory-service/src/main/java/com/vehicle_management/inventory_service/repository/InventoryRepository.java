package com.vehicle_management.inventory_service.repository;

import com.vehicle_management.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link Inventory} entities.
 * Extends {@link JpaRepository} to provide CRUD operations and query methods.
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
