package com.Vehicle_management_system.inventory_service.service.implementation;

import com.Vehicle_management_system.inventory_service.model.SparePartModel;
import com.Vehicle_management_system.inventory_service.repository.SparePartRepository;
import com.Vehicle_management_system.inventory_service.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparePartServiceImpl implements SparePartService {

    @Autowired
    private SparePartRepository sparePartRepository;

    /**
     *
     * @param sparePart
     * @return
     */
    @Override
    public SparePartModel saveSparePart(SparePartModel sparePart) {
        return sparePartRepository.save(sparePart);
    }

    /**
     *
     * @return
     */
    @Override
    public List<SparePartModel> getAllSpareParts() {
        return sparePartRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Optional<SparePartModel> getSparePartById(Long id) {
        return sparePartRepository.findById(id);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public ResponseEntity<?> deleteSparePart(Long id) {
        sparePartRepository.deleteById(id);
        return ResponseEntity.ok("Successfully Deleted");

    }
}