package com.Vehicle_management_system.service_record_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * This class represents a service record entity in the system,
 * containing details of services performed on vehicles.
 */

@Entity
@Table(name = "services")

public class ServiceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerNic;
    private String vin;
    private String vehicleModel;
    private String termOfService;
    private LocalDate nextServiceDate;
    private LocalDate serviceDate;


    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getTermOfService() {
        return termOfService;
    }

    public void setTermOfService(String termOfService) {
        this.termOfService = termOfService;
    }

    public LocalDate getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(LocalDate nextServiceDate) {
        this.nextServiceDate = nextServiceDate;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }
}