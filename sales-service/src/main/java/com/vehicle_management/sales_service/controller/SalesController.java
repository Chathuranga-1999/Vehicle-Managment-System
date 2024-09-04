package com.vehicle_management.sales_service.controller;

import com.vehicle_management.sales_service.constants.SalesConstants;
import com.vehicle_management.sales_service.model.Sales;
import com.vehicle_management.sales_service.service.SalesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling CRUD operations related to Sales.
 * <p>
 * This class provides RESTful endpoints for managing sales data, including creating, retrieving, updating,
 * and deleting sales records. It uses the {@link SalesService} to perform these operations and returns appropriate
 * HTTP responses based on the outcome of the service methods.
 * </p>
 */
@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    /**
     * Endpoint for adding a new sale.
     * <p>
     * Receives a {@link Sales} object in the request body, validates it, and saves it to the database.
     * Returns the saved {@link Sales} object with a status of {@code HttpStatus.CREATED}.
     * </p>
     *
     * @param sales The {@link Sales} object to be added.
     * @return A {@link ResponseEntity} containing the saved {@link Sales} object and HTTP status {@code CREATED}.
     */
    @PostMapping("/add")
    public ResponseEntity<Sales> addSale(@Valid @RequestBody Sales sales) {
        Sales savedSale = salesService.addSale(sales);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }

    /**
     * Endpoint for retrieving all sold vehicles.
     * <p>
     * Queries the {@link SalesService} for a list of all sold vehicles and returns it with a status of {@code HttpStatus.OK}.
     * </p>
     *
     * @return A {@link ResponseEntity} containing a list of {@link Sales} objects and HTTP status {@code OK}.
     */
    @GetMapping("/sold")
    public ResponseEntity<List<Sales>> getSoldVehicles() {
        List<Sales> soldVehicles = salesService.getSoldVehicles();
        return new ResponseEntity<>(soldVehicles, HttpStatus.OK);
    }

    /**
     * Endpoint for editing an existing sold vehicle.
     * <p>
     * Receives a {@link Sales} object in the request body, validates it, and updates the corresponding record in the database.
     * Returns the updated {@link Sales} object with a status of {@code HttpStatus.OK}.
     * </p>
     *
     * @param sales The {@link Sales} object with updated information.
     * @return A {@link ResponseEntity} containing the updated {@link Sales} object and HTTP status {@code OK}.
     */
    @PutMapping("/edit")
    public ResponseEntity<Sales> editSoldVehicle(@Valid @RequestBody Sales sales) {
        Sales updatedSale = salesService.editSoldVehicle(sales);
        return new ResponseEntity<>(updatedSale, HttpStatus.OK);
    }

    /**
     * Endpoint for deleting a sold vehicle by ID.
     * <p>
     * Deletes the sold vehicle with the specified ID from the database.
     * Returns a success message with a status of {@code HttpStatus.OK}.
     * </p>
     *
     * @param saleID The ID of the sold vehicle to be deleted.
     * @return A {@link ResponseEntity} containing a success message and HTTP status {@code OK}.
     */
    @DeleteMapping("/delete/{saleID}")
    public ResponseEntity<String> deleteSoldVehicle(@PathVariable Long saleID) {
        salesService.deleteSoldVehicle(saleID);
        return new ResponseEntity<>(SalesConstants.SOLD_VEHICLE_DELETED_SUCCESS, HttpStatus.OK);
    }
}
