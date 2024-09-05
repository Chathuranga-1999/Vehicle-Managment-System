package com.vehicle_management.inventory_service.model;

import com.vehicle_management.inventory_service.constants.InventoryConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an inventory entity in the system.
 * This class is used to map inventory data to the database.
 */
@Entity
@Table(name = InventoryConstants.TABLE_NAME)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    /**
     * The unique identifier for the inventory item.
     * This field is auto-generated and serves as the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the spare part.
     * This field is mandatory and cannot be null.
     */
    @Column(name = InventoryConstants.COLUMN_PART_NAME, nullable = false)
    private String partName;

    /**
     * The make of the vehicle associated with the spare part.
     * This field is mandatory and cannot be null.
     */
    @Column(name = InventoryConstants.COLUMN_VEHICLE_MAKE, nullable = false)
    private String vehicleMake;

    /**
     * The model of the vehicle associated with the spare part.
     * This field is mandatory and cannot be null.
     */
    @Column(name = InventoryConstants.COLUMN_VEHICLE_MODEL, nullable = false)
    private String vehicleModel;

    /**
     * The quantity of the spare part in stock.
     * This field is mandatory and cannot be null.
     */
    @Column(name = InventoryConstants.COLUMN_QUANTITY_STOCK, nullable = false)
    private int quantityStock;

    /**
     * The price per unit of the spare part.
     * This field is mandatory and cannot be null.
     */
    @Column(name = InventoryConstants.COLUMN_PRICE_PER_UNIT, nullable = false)
    private double pricePerUnit;
}
