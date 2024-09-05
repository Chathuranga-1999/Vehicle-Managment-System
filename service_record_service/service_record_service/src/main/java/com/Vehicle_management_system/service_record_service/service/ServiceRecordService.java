package com.Vehicle_management_system.service_record_service.service;

import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import org.springframework.http.ResponseEntity;

/**
 * This interface defines the contract for managing service records.
 * It provides methods for retrieving, saving, updating, and deleting service records.
 */
public interface ServiceRecordService {
    /**
     * Retrieves service records by vehicle ID.
     *
     * @param vehicleId the ID of the vehicle whose service record is to be retrieved
     * @return ResponseEntity containing the service record
     */
    ResponseEntity<?> getServiceRecordsByVehicleId(Long vehicleId);

    /**
     * Retrieves all service records.
     *
     * @return ResponseEntity containing a list of all service records
     */

    ResponseEntity<?> getServiceRecords();
    /**
     * Saves a new service record.
     *
     * @param serviceRecord the service record to save
     * @return the saved ServiceRecord object
     */




    ServiceRecord saveServiceRecord(ServiceRecord serviceRecord);
    /**
     * Deletes a service record by its vehicle ID.
     *
     * @param vehicleId the ID of the vehicle whose service record is to be deleted
     * @return ResponseEntity indicating the result of the deletion
     */

    ResponseEntity<?> deleteServiceRecords(Long vehicleId);
    /**
     * Adds a new service record.
     *
     * @param serviceRecord the service record to add
     * @return the added ServiceRecord object
     */

    ServiceRecord addServiceRecord(ServiceRecord serviceRecord);
    /**
     * Updates an existing service record.
     *
     * @param id the ID of the service record to update
     * @param updatedRecord the updated service record data
     * @return the updated ServiceRecord object
     */

    ServiceRecord updateServiceRecord(Long id, ServiceRecord updatedRecord);
}