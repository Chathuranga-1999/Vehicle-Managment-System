package com.vehicle_management.customer_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a customer entity in the system.
 * This class is mapped to a database table using JPA annotations.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    /**
     * The unique identifier for the customer.
     * This value is automatically generated by the database.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first name of the customer.
     */
    private String firstName;

    /**
     * The last name of the customer.
     */
    private String lastName;

    /**
     * The National Identity Card (NIC) number of the customer.
     */
    private String nicNumber;

    /**
     * The contact number of the customer.
     */
    private String contactNumber;

    /**
     * The address of the customer.
     */
    private String address;
}