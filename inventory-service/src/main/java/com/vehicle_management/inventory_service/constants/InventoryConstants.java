package com.vehicle_management.inventory_service.constants;

/**
 * This class contains constant values for the Inventory entity.
 * These constants represent table and column names used in the database schema
 * and are utilized throughout the application to avoid hardcoding strings.
 */
public class InventoryConstants {

    /**
     * The name of the table storing inventory data.
     */
    public static final String TABLE_NAME = "Inventory";

    /**
     * The name of the column for storing the part name.
     */
    public static final String COLUMN_PART_NAME = "part_name";

    /**
     * The name of the column for storing the vehicle make.
     */
    public static final String COLUMN_VEHICLE_MAKE = "vehicle_make";

    /**
     * The name of the column for storing the vehicle model.
     */
    public static final String COLUMN_VEHICLE_MODEL = "vehicle_model";

    /**
     * The name of the column for storing the quantity of stock available.
     */
    public static final String COLUMN_QUANTITY_STOCK = "quantity_stock";

    /**
     * The name of the column for storing the price per unit of the inventory item.
     */
    public static final String COLUMN_PRICE_PER_UNIT = "price_per_unit";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private InventoryConstants() {}
}
