package com.vehicle_management.customer_service.service.impl;

import com.vehicle_management.customer_service.constants.CustomerConstants;
import com.vehicle_management.customer_service.exceptions.CustomerNotFoundException;
import com.vehicle_management.customer_service.model.Customer;
import com.vehicle_management.customer_service.repository.CustomerRepository;
import com.vehicle_management.customer_service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the CustomerService interface.
 * Provides business logic for managing customers, including CRUD operations.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Retrieves all customers from the repository.
     *
     * @return a list of all customers.
     */
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a customer by its ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return an Optional containing the customer if found, or an empty Optional if not found.
     * @throws CustomerNotFoundException if the customer with the given ID is not found.
     */
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return Optional.ofNullable(customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND + id)));
    }

    /**
     * Adds a new customer to the repository.
     *
     * @param customer the customer entity to be added.
     * @return the added customer.
     */
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Updates an existing customer identified by its ID.
     *
     * @param id the ID of the customer to update.
     * @param customer the customer entity with updated information.
     * @return the updated customer.
     * @throws CustomerNotFoundException if the customer with the given ID is not found.
     */
    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND + id));

        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setNicNumber(customer.getNicNumber());
        existingCustomer.setContactNumber(customer.getContactNumber());
        existingCustomer.setAddress(customer.getAddress());

        return customerRepository.save(existingCustomer);
    }

    /**
     * Deletes a customer identified by its ID.
     *
     * @param id the ID of the customer to delete.
     * @throws CustomerNotFoundException if the customer with the given ID is not found.
     */
    @Override
    public void deleteCustomer(Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(CustomerConstants.CUSTOMER_NOT_FOUND + id));

        customerRepository.delete(existingCustomer);
    }
}
