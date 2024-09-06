package com.Vehicle_management_system.service_record_service.repository;

import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JpaRepository to provide CRUD operations for the ServiceRecord entity.
 * It allows interaction with the database for operations such as saving, deleting, and retrieving service records.
 */

public interface servicerecordrepository extends JpaRepository<ServiceRecord,Long> {
}