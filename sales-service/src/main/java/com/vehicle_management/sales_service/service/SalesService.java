package com.vehicle_management.sales_service.service;

import com.vehicle_management.sales_service.model.Sales;

import java.util.List;

/**
 * Service interface for managing sales-related operations.
 *
 * Provides methods for adding sales, retrieving sold vehicles, editing and deleting sold vehicles.
 */
public interface SalesService {

    /**
     * Adds a new sale to the repository.
     *
     * @param sales The sales entity to be added.
     * @return The added sales entity.
     */
    Sales addSale(Sales sales);

    /**
     * Retrieves a list of all sold vehicles.
     *
     * @return A list of sales entities with non-null vehicle IDs, indicating they have been sold.
     */
    List<Sales> getSoldVehicles();

    /**
     * Edits an existing sale in the repository.
     *
     * @param sales The sales entity with updated information.
     * @return The updated sales entity.
     */
    Sales editSoldVehicle(Sales sales);

    /**
     * Deletes a sale from the repository.
     *
     * @param saleID The ID of the sale to be deleted.
     */
    void deleteSoldVehicle(Long saleID);

}
