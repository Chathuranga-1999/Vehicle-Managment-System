package com.Vehicle_management_system.service_record_service.repository;

import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface servicerecordrepository extends JpaRepository<ServiceRecord,Long> {
}