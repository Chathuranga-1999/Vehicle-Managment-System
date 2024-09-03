package com.Vehicle_management_system.inventory_service.repository;

import com.Vehicle_management_system.inventory_service.model.SparePartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository extends JpaRepository<SparePartModel, Long> {
}