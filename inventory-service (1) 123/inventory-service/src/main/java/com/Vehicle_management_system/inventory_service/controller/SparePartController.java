package com.Vehicle_management_system.inventory_service.controller;

import com.Vehicle_management_system.inventory_service.model.SparePartModel;
import com.Vehicle_management_system.inventory_service.repository.SparePartRepository;
import com.Vehicle_management_system.inventory_service.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/spareparts")
public class SparePartController {

    private final SparePartRepository sparePartRepository;
    @Autowired
    private SparePartService sparePartService;

    // Create
    @PostMapping
    public ResponseEntity<SparePartModel> createSparePart(@RequestBody SparePartModel sparePart) {
        SparePartModel createdSparePart = sparePartService.saveSparePart(sparePart);
        return ResponseEntity.ok(createdSparePart);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<SparePartModel>> getAllSpareParts() {
        List<SparePartModel> spareParts = sparePartService.getAllSpareParts();
        return ResponseEntity.ok(spareParts);
    }

    // Read By ID

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<SparePartModel> getSparePartById(@PathVariable Long id) {
        Optional<SparePartModel> sparePart = sparePartService.getSparePartById(id);
        return sparePart.map(ResponseEntity::ok)
                        .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    public SparePartController(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    /**
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSparePart(@PathVariable Long id) {

        return ResponseEntity.ok(sparePartService.deleteSparePart(id));
    }

    /**
     *
     * @param id
     * @param sparePartDetails
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<SparePartModel> updateSparePart(
            @PathVariable Long id,
            @RequestBody SparePartModel sparePartDetails) {

        Optional<SparePartModel> sparePartOptional = sparePartRepository.findById(id);

        if (sparePartOptional.isPresent()) {
            SparePartModel sparePart = sparePartOptional.get();
            sparePart.setPartName(sparePartDetails.getPartName());
            sparePart.setVehicleMake(sparePartDetails.getVehicleMake());
            sparePart.setVehicleModel(sparePartDetails.getVehicleModel());
            sparePart.setQuantityInStock(sparePartDetails.getQuantityInStock());
            sparePart.setPricePerUnit(sparePartDetails.getPricePerUnit());

            SparePartModel updatedSparePart = sparePartRepository.save(sparePart);
            return ResponseEntity.ok(updatedSparePart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}