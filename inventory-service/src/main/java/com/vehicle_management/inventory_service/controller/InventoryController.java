package com.vehicle_management.inventory_service.controller;

import com.vehicle_management.inventory_service.exceptions.InventoryNotFoundException;
import com.vehicle_management.inventory_service.model.Inventory;
import com.vehicle_management.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing inventory parts.
 * Provides endpoints for CRUD operations on inventory parts.
 */
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    /**
     * Retrieves a list of all inventory parts.
     *
     * @return a list of all inventory parts.
     */
    @GetMapping
    public List<Inventory> getAllParts() {
        return inventoryService.getAllParts();
    }

    /**
     * Retrieves a specific inventory part by its ID.
     *
     * @param id the ID of the inventory part to retrieve.
     * @return a ResponseEntity containing the inventory part if found, or an error response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getPartById(@PathVariable Long id) {
        Optional<Inventory> part = inventoryService.getPartById(id);
        return part.map(ResponseEntity::ok)
                .orElseThrow(() -> new InventoryNotFoundException("Part not found with ID: " + id));
    }

    /**
     * Adds a new inventory part.
     *
     * @param inventory the inventory part to add.
     * @return the added inventory part.
     */
    @PostMapping
    public Inventory addPart(@RequestBody Inventory inventory) {
        return inventoryService.addPart(inventory);
    }

    /**
     * Updates an existing inventory part identified by its ID.
     *
     * @param id the ID of the inventory part to update.
     * @param inventory the inventory part with updated information.
     * @return a ResponseEntity containing the updated inventory part.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Inventory> updatePart(@PathVariable Long id, @RequestBody Inventory inventory) {
        Inventory updatedPart = inventoryService.updatePart(id, inventory);
        return ResponseEntity.ok(updatedPart);
    }

    /**
     * Deletes an inventory part identified by its ID.
     *
     * @param id the ID of the inventory part to delete.
     * @return a ResponseEntity with no content.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePart(@PathVariable Long id) {
        inventoryService.deletePart(id);
        return ResponseEntity.ok("Successfully Deleted");
    }
}
