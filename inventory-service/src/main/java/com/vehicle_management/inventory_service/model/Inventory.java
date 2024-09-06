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

    /**
     * Gets the ID of the spare part.
     *
     * @return the ID of the spare part.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the ID of the spare part.
     *
     * @param id the ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the spare part.
     *
     * @return the name of the spare part.
     */
    public String getPartName() {
        return partName;
    }

    /**
     * Sets the name of the spare part.
     *
     * @param partName the name of the spare part to set.
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * Gets the vehicle make associated with the spare part.
     *
     * @return the vehicle make.
     */
    public String getVehicleMake() {
        return vehicleMake;
    }

    /**
     * Sets the vehicle make associated with the spare part.
     *
     * @param vehicleMake the vehicle make to set.
     */
    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    /**
     * Gets the vehicle model associated with the spare part.
     *
     * @return the vehicle model.
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * Sets the vehicle model associated with the spare part.
     *
     * @param vehicleModel the vehicle model to set.
     */
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    /**
     * Gets the quantity of the spare part available in stock.
     *
     * @return the quantity in stock.
     */
    public int getQuantityStock() {
        return quantityStock;
    }

    /**
     * Sets the quantity of the spare part available in stock.
     *
     * @param quantityStock the quantity in stock to set.
     */
    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    /**
     * Gets the price per unit of the spare part.
     *
     * @return the price per unit.
     */
    public double getPricePerUnit() {
        return pricePerUnit;
    }

    /**
     * Sets the price per unit of the spare part.
     *
     * @param pricePerUnit the price per unit to set.
     */
    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

}
