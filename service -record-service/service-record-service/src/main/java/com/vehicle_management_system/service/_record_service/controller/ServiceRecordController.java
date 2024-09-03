package com.vehicle_management_system.service._record_service.controller;

import com.vehicle_management_system.service._record_service.model.ServiceRecord;
import com.vehicle_management_system.service._record_service.service.implementation.ApiServiceImpl;
import com.vehicle_management_system.service._record_service.service.implementation.ServiceRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/call")
public class ServiceRecordController {
    @Autowired
    private ApiServiceImpl apiService;

    @Autowired
    private ServiceRecordServiceImpl serviceRecordService;

    @GetMapping("/service-record/{id}")
    public ResponseEntity<?> getServiceRecord(@PathVariable Long id) {
        return ResponseEntity.ok(serviceRecordService.getServiceRecordsByVehicleId(id));
    }

    @GetMapping("/service-record/")
    public ResponseEntity<?> getAllServiceRecord() {
        return ResponseEntity.ok(serviceRecordService.getServiceRecords());
    }

    @PostMapping("/service-record/save")
    public ResponseEntity<?> saveServiceRecord(@RequestBody ServiceRecord serviceRecord) {
        return ResponseEntity.ok(serviceRecordService.saveServiceRecord(serviceRecord));
    }

    @DeleteMapping("/service-record/delete/{id}")
    public ResponseEntity<?> deleteServiceRecord(@PathVariable Long id) {
        return ResponseEntity.ok(serviceRecordService.deleteServiceRecords(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceRecord> updateServiceRecord(@PathVariable Long id, @RequestBody ServiceRecord updatedRecord) {
        ServiceRecord updatedServiceRecord = serviceRecordService.updateServiceRecord(id, updatedRecord);
        return ResponseEntity.ok(updatedServiceRecord);
    }
}
