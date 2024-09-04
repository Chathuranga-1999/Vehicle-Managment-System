package com.vehicle_management.customer_service.repository;

import com.vehicle_management.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing customer data.
 * Extends JpaRepository to provide CRUD operations for the Customer entity.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Additional query methods can be defined here if needed
}
