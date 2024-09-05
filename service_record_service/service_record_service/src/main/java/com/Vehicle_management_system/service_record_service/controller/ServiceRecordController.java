package com.Vehicle_management_system.service_record_service.controller;

import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import com.Vehicle_management_system.service_record_service.service.implementation.ApiServiceImpl;
import com.Vehicle_management_system.service_record_service.service.implementation.ServiceRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This controller class handles HTTP requests related to service records.
 * It provides endpoints for retrieving, saving, updating, and deleting service records.
 */
@RestController
@RequestMapping("/api/call")
public class ServiceRecordController {
    @Autowired
    private ApiServiceImpl apiService;

    @Autowired
    private ServiceRecordServiceImpl serviceRecordService;
    /**
     * Retrieves a service record by its ID.
     *
     * @param id the ID of the service record to retrieve
     * @return ResponseEntity containing the service record or an appropriate message
     */

    @GetMapping("/service-record/{id}")
    public ResponseEntity<?> getServiceRecord(@PathVariable Long id) {
        return ResponseEntity.ok(serviceRecordService.getServiceRecordsByVehicleId(id));
    }

    /**
     * Retrieves all service records.
     *
     * @return ResponseEntity containing a list of all service records
     */

    @GetMapping("/service-record/")
    public ResponseEntity<?> getAllServiceRecord() {
        return ResponseEntity.ok(serviceRecordService.getServiceRecords());
    }

    /**
     * Saves a new service record.
     *
     * @param serviceRecord the service record to save
     * @return ResponseEntity containing the saved service record
     */
    @PostMapping("/service-record/save")
    public ResponseEntity<?> saveServiceRecord(@RequestBody ServiceRecord serviceRecord) {
        return ResponseEntity.ok(serviceRecordService.saveServiceRecord(serviceRecord));
    }

    /**
     * Deletes a service record by its ID.
     *
     * @param id the ID of the service record to delete
     * @return ResponseEntity indicating the result of the deletion
     */

    @DeleteMapping("/service-record/delete/{id}")
    public ResponseEntity<?> deleteServiceRecord(@PathVariable Long id) {
        return ResponseEntity.ok(serviceRecordService.deleteServiceRecords(id));
    }
    /**
     * Updates an existing service record with new details.
     *
     * @param id the ID of the service record to update
     * @param updatedRecord the updated service record data
     * @return ResponseEntity containing the updated service record
     */

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRecord> updateServiceRecord(@PathVariable Long id, @RequestBody ServiceRecord updatedRecord) {
        ServiceRecord updatedServiceRecord = serviceRecordService.updateServiceRecord(id, updatedRecord);
        return ResponseEntity.ok(updatedServiceRecord);
    }
}