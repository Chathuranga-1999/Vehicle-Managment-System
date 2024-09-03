package com.vehicle_management.vehicle_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Represents a vehicle entity in the system.
 */
@Entity
@Table(name = "Vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    /**
     * The unique identifier for the vehicle.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleID;

    /**
     * The make of the vehicle (e.g., Toyota, Ford).
     */
    private String make;

    /**
     * The model of the vehicle (e.g., Corolla, Mustang).
     */
    private String model;

    /**
     * The manufacturing year of the vehicle.
     */
    private int year;

    /**
     * The Vehicle Identification Number (VIN) of the vehicle.
     */
    private String vin;

    /**
     * The price of the vehicle.
     */
    private double price;

    /**
     * The status of the vehicle (e.g., Available, Not Available).
     */
    private String status;

    /**
     * A URL or path to the photos of the vehicle.
     */
    private String photos;

    /**
     * The category of the vehicle (e.g., SUV, Sedan).
     */
    private String category;

    /**
     * The date when the vehicle was added to the system.
     */
    @Temporal(TemporalType.DATE)
    private Date addDate;
}
