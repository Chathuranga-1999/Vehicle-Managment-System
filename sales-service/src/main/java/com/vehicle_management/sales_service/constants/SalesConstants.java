package com.vehicle_management.sales_service.constants;

/**
 * Constants used throughout the Sales Service.
 * <p>
 * Provides constant values for error messages, success messages, and other commonly used strings related to sales operations.
 * These constants help maintain consistency and facilitate easier management of messages used in the Sales Service.
 * </p>
 */
public class SalesConstants {

    /**
     * Error message when the customer ID is not provided.
     */
    public static final String CUSTOMER_ID_REQUIRED = "Customer is required";

    /**
     * Error message when the Vehicle Identification Number (VIN) is not provided.
     */
    public static final String VIN_REQUIRED = "VIN is required";

    /**
     * Error message when the category of the vehicle is not provided.
     */
    public static final String CATEGORY_REQUIRED = "Category is required";

    /**
     * Error message when the vehicle model is not provided.
     */
    public static final String VEHICLE_MODEL_REQUIRED = "Vehicle Model is required";

    /**
     * Error message when the sold date is not provided.
     */
    public static final String SOLD_DATE_REQUIRED = "Sold Date is required";

    /**
     * Error message when the year of manufacture is not provided.
     */
    public static final String YEAR_OF_MANUFACTURE_REQUIRED = "Year of Manufacture is required";

    /**
     * Error message when the manufacturer of the vehicle is not provided.
     */
    public static final String MANUFACTURED_BY_REQUIRED = "Manufactured By is required";

    /**
     * Error message when the buyer's National Identity Card (NIC) is not provided.
     */
    public static final String BUYER_NIC_REQUIRED = "Buyer NIC is required";

    /**
     * Success message indicating that a sold vehicle has been successfully deleted.
     */
    public static final String SOLD_VEHICLE_DELETED_SUCCESS = "Sold vehicle deleted successfully.";

    /**
     * Error message used when a sale cannot be found with the specified ID.
     * <p>
     * The placeholder for the sale ID will be appended to this message.
     * </p>
     */
    public static final String SALE_NOT_FOUND = "Sale not found with ID: ";
}
