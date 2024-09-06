package com.vehicle_management.sales_service.repository;

import com.vehicle_management.sales_service.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link Sales} entities.
 *
 * Provides methods for performing CRUD operations and custom queries on the Sales table.
 */
@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

    /**
     * Finds all sales made by a specific customer.
     *
     * @param customerID The ID of the customer for which to find sales.
     * @return A list of {@link Sales} entities made by the given customer ID.
     */
    List<Sales> findByCustomerID(Long customerID);

    /**
     * Finds all sales with a non-null VIN.
     *
     * This method assumes that sales with non-null VINs are considered sold.
     *
     * @return A list of {@link Sales} entities with non-null VINs.
     */
    List<Sales> findByVinNotNull();
}
