package com.Vehicle_management_system.service_record_service.service.implementation;

import com.Vehicle_management_system.service_record_service.constants.ServiceRecordConstants;
import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import com.Vehicle_management_system.service_record_service.repository.servicerecordrepository;
import com.Vehicle_management_system.service_record_service.service.ServiceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceRecordServiceImpl implements ServiceRecordService {
    @Autowired
    private servicerecordrepository serviceRecordRepository;

    @Override
    public ResponseEntity<?> getServiceRecordsByVehicleId(Long vehicleId) {
        return ResponseEntity.ok(serviceRecordRepository.findById(vehicleId));
    }

    @Override
    public ResponseEntity<?> getServiceRecords() {
        return ResponseEntity.ok(serviceRecordRepository.findAll());
    }

    @Override
    public ServiceRecord saveServiceRecord(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

    @Override
    public ResponseEntity<?> deleteServiceRecords(Long vehicleId) {
        serviceRecordRepository.deleteById(vehicleId);
        return ResponseEntity.ok(ServiceRecordConstants.SUCCESSFULLY_DELETED_RECORD);
    }

    @Override
    public ServiceRecord addServiceRecord(ServiceRecord serviceRecord) {
        return serviceRecordRepository.save(serviceRecord);
    }

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