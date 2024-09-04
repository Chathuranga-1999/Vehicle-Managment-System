package com.Vehicle_management_system.inventory_service.service;

import com.Vehicle_management_system.inventory_service.model.SparePartModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SparePartService {
    SparePartModel saveSparePart(SparePartModel sparePart);

    List<SparePartModel> getAllSpareParts();

    Optional<SparePartModel> getSparePartById(Long id);

    ResponseEntity<?> deleteSparePart(Long id);
}
