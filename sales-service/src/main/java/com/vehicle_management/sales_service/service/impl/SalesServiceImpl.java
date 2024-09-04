package com.vehicle_management.sales_service.service.impl;

import com.vehicle_management.sales_service.constants.SalesConstants;
import com.vehicle_management.sales_service.exceptions.SaleNotFoundException;
import com.vehicle_management.sales_service.model.Sales;
import com.vehicle_management.sales_service.repository.SalesRepository;
import com.vehicle_management.sales_service.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link SalesService} interface.
 * <p>
 * Provides concrete methods for managing sales data, including adding, retrieving, editing,
 * and deleting sales records. Uses the {@link SalesRepository} for database operations.
 * </p>
 */
@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesRepository salesRepository;

    /**
     * Adds a new sale to the database.
     * <p>
     * Saves the provided {@link Sales} object to the database and returns the saved instance.
     * </p>
     *
     * @param sales The {@link Sales} object to be added.
     * @return The saved {@link Sales} object.
     */
    @Override
    public Sales addSale(Sales sales) {
        return salesRepository.save(sales);
    }

    /**
     * Retrieves a list of all sold vehicles.
     * <p>
     * Queries the {@link SalesRepository} for a list of sales where the VIN is not null.
     * </p>
     *
     * @return A list of {@link Sales} objects representing sold vehicles.
     */
    @Override
    public List<Sales> getSoldVehicles() {
        return salesRepository.findByVinNotNull();
    }

    /**
     * Edits an existing sold vehicle.
     * <p>
     * Checks if the sale with the provided ID exists. If it does, updates the record with the new information.
     * Throws a {@link SaleNotFoundException} if the sale with the given ID does not exist.
     * </p>
     *
     * @param sales The {@link Sales} object containing updated information.
     * @return The updated {@link Sales} object.
     * @throws SaleNotFoundException if the sale with the given ID is not found.
     */
    @Override
    public Sales editSoldVehicle(Sales sales) {
        if (!salesRepository.existsById(sales.getSaleID())) {
            throw new SaleNotFoundException(SalesConstants.SALE_NOT_FOUND + sales.getSaleID());
        }
        return salesRepository.save(sales);
    }

    /**
     * Deletes a sold vehicle by its ID.
     * <p>
     * Checks if the sale with the provided ID exists. If it does, deletes the record from the database.
     * Throws a {@link SaleNotFoundException} if the sale with the given ID does not exist.
     * </p>
     *
     * @param saleID The ID of the sold vehicle to be deleted.
     * @throws SaleNotFoundException if the sale with the given ID is not found.
     */
    @Override
    public void deleteSoldVehicle(Long saleID) {
        if (!salesRepository.existsById(saleID)) {
            throw new SaleNotFoundException(SalesConstants.SALE_NOT_FOUND + saleID);
        }
        salesRepository.deleteById(saleID);
    }
}
