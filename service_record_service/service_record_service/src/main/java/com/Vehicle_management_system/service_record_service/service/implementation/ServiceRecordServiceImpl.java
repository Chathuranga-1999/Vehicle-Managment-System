package com.Vehicle_management_system.service_record_service.service.implementation;

import com.Vehicle_management_system.service_record_service.constants.ServiceRecordConstants;
import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import com.Vehicle_management_system.service_record_service.repository.servicerecordrepository;
import com.Vehicle_management_system.service_record_service.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * This service implementation provides methods for managing service records.
 * It implements the ServiceRecordService interface and interacts with the database using the repository layer.
 */

@Service
public class ServiceRecordServiceImpl implements ServiceRecordService {
    @Autowired
    private servicerecordrepository serviceRecordRepository;

    @Override
    /**
     * Retrieves a service record by its vehicle ID.
     *
     * @param vehicleId the ID of the vehicle whose service record is to be retrieved
     * @return ResponseEntity containing the service record
     */
    public ResponseEntity<?> getServiceRecordsByVehicleId(Long vehicleId) {
        return ResponseEntity.ok(serviceRecordRepository.findById(vehicleId));
    }

    @Override

    /**
     * Retrieves all service records.
     *
     * @return ResponseEntity containing a list of all service records
     */
    public ResponseEntity<?> getServiceRecords() {
        return ResponseEntity.ok(serviceRecordRepository.findAll());
    }

    @Override
    public ServiceRecord saveServiceRecord(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

    @Override
    /**
     * Saves a new service record to the database.
     *
     * @param serviceRecord the service record to save
     * @return the saved ServiceRecord object
     */
    public ResponseEntity<?> deleteServiceRecords(Long vehicleId) {
        serviceRecordRepository.deleteById(vehicleId);
        return ResponseEntity.ok(ServiceRecordConstants.SUCCESSFULLY_DELETED_RECORD);
    }

    @Override
    /**
     * Deletes a service record by its vehicle ID.
     *
     * @param vehicleId the ID of the vehicle whose service record is to be deleted
     * @return ResponseEntity indicating the result of the deletion
     */
    public ServiceRecord addServiceRecord(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

    /**
     * Updates an existing service record with new details.
     *
     * @param id the ID of the service record to update
     * @param updatedRecord the updated service record data
     * @return the updated ServiceRecord object
     * @throws RuntimeException if the service record is not found
     */
    @Override
    public ServiceRecord updateServiceRecord(Long id, ServiceRecord updatedRecord) {
        Optional<ServiceRecord> existingRecordOptional = serviceRecordRepository.findById(id);

        if (existingRecordOptional.isPresent()) {
            ServiceRecord existingRecord = existingRecordOptional.get();
            existingRecord.setCustomerNic(updatedRecord.getCustomerNic());
            existingRecord.setVin(updatedRecord.getVin());
            existingRecord.setVehicleModel(updatedRecord.getVehicleModel());
            existingRecord.setTermOfService(updatedRecord.getTermOfService());
            existingRecord.setNextServiceDate(updatedRecord.getNextServiceDate());
            existingRecord.setServiceDate(updatedRecord.getServiceDate());

            return serviceRecordRepository.save(existingRecord);
        } else {
            throw new RuntimeException(ServiceRecordConstants.SERVICE_RECORD_NOT_FOUND + id);
        }
    }
}