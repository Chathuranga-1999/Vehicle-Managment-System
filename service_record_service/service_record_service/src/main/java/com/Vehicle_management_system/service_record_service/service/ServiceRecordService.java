package com.Vehicle_management_system.service_record_service.service;

import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import org.springframework.http.ResponseEntity;

public interface ServiceRecordService {
    ResponseEntity<?> getServiceRecordsByVehicleId(Long vehicleId);

    ResponseEntity<?> getServiceRecords();




    ServiceRecord saveServiceRecord(ServiceRecord serviceRecord);

    ResponseEntity<?> deleteServiceRecords(Long vehicleId);

    ServiceRecord addServiceRecord(ServiceRecord serviceRecord);

    ServiceRecord updateServiceRecord(Long id, ServiceRecord updatedRecord);
}