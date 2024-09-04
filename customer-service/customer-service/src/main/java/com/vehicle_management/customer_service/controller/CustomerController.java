package com.vehicle_management.customer_service.controller;

import com.vehicle_management.customer_service.constants.CustomerConstants;
import com.vehicle_management.customer_service.model.Customer;
import com.vehicle_management.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing customer-related operations.
 * Provides endpoints for CRUD operations on customers.
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Retrieves all customers from the system.
     *
     * @return a list of all customers.
     */
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Retrieves a customer by its ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return a ResponseEntity containing the customer if found, or a 404 status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Adds a new customer to the system.
     *
     * @param customer the customer entity to be added.
     * @return the added customer.
     */
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    /**
     * Updates an existing customer by its ID.
     *
     * @param id the ID of the customer to update.
     * @param customer the updated customer entity.
     * @return a ResponseEntity containing the updated customer if successful, or a 404 status if the customer is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(id, customer);
        return updatedCustomer != null ? ResponseEntity.ok(updatedCustomer) : ResponseEntity.notFound().build();
    }

    /**
     * Deletes a customer by its ID.
     *
     * @param id the ID of the customer to delete.
     * @return a ResponseEntity containing a success message if the deletion is successful.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok(CustomerConstants.CUSTOMER_DELETED_SUCCESSFULLY);
    }
}
