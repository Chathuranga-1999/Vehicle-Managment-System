package com.vehicle_management_system.service._record_service.repository;

import com.vehicle_management_system.service._record_service.model.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface servicerecordrepository extends JpaRepository<ServiceRecord,Long> {
}
