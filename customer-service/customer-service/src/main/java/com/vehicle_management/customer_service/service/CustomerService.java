package com.vehicle_management.customer_service.service;

import com.vehicle_management.customer_service.model.Customer;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing customer-related operations.
 * Provides methods for CRUD operations on customer entities.
 */
public interface CustomerService {

    /**
     * Retrieves all customers.
     *
     * @return a list of all customers.
     */
    List<Customer> getAllCustomers();

    /**
     * Retrieves a customer by its ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return an Optional containing the customer if found, or an empty Optional if not found.
     */
    Optional<Customer> getCustomerById(Long id);

    /**
     * Adds a new customer.
     *
     * @param customer the customer entity to be added.
     * @return the added customer.
     */
    Customer addCustomer(Customer customer);

    /**
     * Updates an existing customer identified by its ID.
     *
     * @param id the ID of the customer to update.
     * @param customer the customer entity with updated information.
     * @return the updated customer.
     */
    Customer updateCustomer(Long id, Customer customer);

    /**
     * Deletes a customer identified by its ID.
     *
     * @param id the ID of the customer to delete.
     */
    void deleteCustomer(Long id);
}
