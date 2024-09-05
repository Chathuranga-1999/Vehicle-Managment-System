package com.vehicle_management.inventory_service.service.impl;

import com.vehicle_management.inventory_service.exceptions.InventoryNotFoundException;
import com.vehicle_management.inventory_service.model.Inventory;
import com.vehicle_management.inventory_service.repository.InventoryRepository;
import com.vehicle_management.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the {@link InventoryService} interface.
 * Provides business logic for managing {@link Inventory} entities.
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    /**
     * Constructs an {@link InventoryServiceImpl} instance with the provided repository.
     *
     * @param inventoryRepository the {@link InventoryRepository} to be used by this service
     */
    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    /**
     * Retrieves all inventory parts from the repository.
     *
     * @return a list of {@link Inventory} entities
     */
    @Override
    public List<Inventory> getAllParts() {
        return inventoryRepository.findAll();
    }

    /**
     * Retrieves an inventory part by its ID.
     *
     * @param id the ID of the inventory part to retrieve
     * @return an {@link Optional} containing the found {@link Inventory} entity
     * @throws InventoryNotFoundException if no inventory part with the given ID is found
     */
    @Override
    public Optional<Inventory> getPartById(Long id) {
        return Optional.ofNullable(inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Part not found with ID: " + id)));
    }

    /**
     * Adds a new inventory part to the repository.
     *
     * @param inventory the {@link Inventory} entity to be added
     * @return the added {@link Inventory} entity
     */
    @Override
    public Inventory addPart(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    /**
     * Updates an existing inventory part.
     *
     * @param id the ID of the inventory part to update
     * @param inventory the {@link Inventory} entity with updated information
     * @return the updated {@link Inventory} entity
     * @throws InventoryNotFoundException if no inventory part with the given ID is found
     */
    @Override
    public Inventory updatePart(Long id, Inventory inventory) {
        Inventory existingPart = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Part not found with ID: " + id));

        existingPart.setPartName(inventory.getPartName());
        existingPart.setVehicleMake(inventory.getVehicleMake());
        existingPart.setVehicleModel(inventory.getVehicleModel());
        existingPart.setQuantityStock(inventory.getQuantityStock());
        existingPart.setPricePerUnit(inventory.getPricePerUnit());
        return inventoryRepository.save(existingPart);
    }

    /**
     * Deletes an inventory part by its ID.
     *
     * @param id the ID of the inventory part to delete
     * @throws InventoryNotFoundException if no inventory part with the given ID is found
     */
    @Override
    public void deletePart(Long id) {
        Inventory existingPart = inventoryRepository.findById(id)
                .orElseThrow(() -> new InventoryNotFoundException("Part not found with ID: " + id));
        inventoryRepository.delete(existingPart);
    }
}
