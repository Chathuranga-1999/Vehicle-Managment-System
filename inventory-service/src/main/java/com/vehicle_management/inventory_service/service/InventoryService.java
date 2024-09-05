package com.vehicle_management.inventory_service.service;

import com.vehicle_management.inventory_service.model.Inventory;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link Inventory} entities.
 * Defines the operations for handling inventory parts in the system.
 */
public interface InventoryService {

    /**
     * Retrieves all inventory parts.
     *
     * @return a list of {@link Inventory} entities
     */
    List<Inventory> getAllParts();

    /**
     * Retrieves an inventory part by its ID.
     *
     * @param id the ID of the inventory part to retrieve
     * @return an {@link Optional} containing the found {@link Inventory} entity,
     *         or an empty {@link Optional} if no part with the given ID is found
     */
    Optional<Inventory> getPartById(Long id);

    /**
     * Adds a new inventory part.
     *
     * @param inventory the {@link Inventory} entity to be added
     * @return the added {@link Inventory} entity
     */
    Inventory addPart(Inventory inventory);

    /**
     * Updates an existing inventory part.
     *
     * @param id the ID of the inventory part to update
     * @param inventory the {@link Inventory} entity with updated information
     * @return the updated {@link Inventory} entity
     */
    Inventory updatePart(Long id, Inventory inventory);

    /**
     * Deletes an inventory part by its ID.
     *
     * @param id the ID of the inventory part to delete
     */
    void deletePart(Long id);
}
