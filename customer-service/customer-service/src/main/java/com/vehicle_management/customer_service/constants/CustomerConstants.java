package com.vehicle_management.customer_service.constants;

/**
 * This class contains constant values related to the Customer service.
 * These constants are used throughout the application to avoid hardcoding strings.
 */
public class CustomerConstants {

    /**
     * Message indicating that a customer was not found by a specific ID.
     * This message is typically used in exception handling.
     */
    public static final String CUSTOMER_NOT_FOUND = "Customer not found with id: ";

    /**
     * Message indicating that a customer was successfully deleted.
     * This message can be used in API responses to indicate a successful delete operation.
     */
    public static final String CUSTOMER_DELETED_SUCCESSFULLY = "Customer deleted successfully.";
}
