package com.vehicle_management.sales_service.model;

import com.vehicle_management.sales_service.constants.SalesConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Entity representing a sale of a vehicle.
 *
 * This class maps to the "Sales" table in the database and contains information
 * about each sale, including vehicle, customer, sale date, and other details.
 */
@Entity
@Table(name = "Sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {

    /**
     * Unique identifier for the sale.
     * This is the primary key of the Sales table and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleID;

    @NotNull(message = SalesConstants.CUSTOMER_ID_REQUIRED)
    private Long customerID;

    /**
     * Vehicle Identification Number (VIN) for the sold vehicle.
     * This field is required and represents the VIN of the vehicle.
     */
    @NotNull(message = SalesConstants.VIN_REQUIRED)
    private String vin;

    /**
     * Category of the vehicle sold.
     * This field is required and represents the category of the vehicle.
     */
    @NotNull(message = SalesConstants.CATEGORY_REQUIRED)
    private String category;

    /**
     * Vehicle model for the sold vehicle.
     * This field is required and represents the model of the vehicle.
     */
    @NotNull(message = SalesConstants.VEHICLE_MODEL_REQUIRED)
    private String vehicleModel;

    /**
     * Date when the sale was made.
     * This field is required and represents the date of the transaction.
     */
    @NotNull(message = SalesConstants.SOLD_DATE_REQUIRED)
    @Temporal(TemporalType.DATE)
    private Date soldDate;

    /**
     * Year of manufacture for the sold vehicle.
     * This field is required and represents the year of manufacture.
     */
    @NotNull(message = SalesConstants.YEAR_OF_MANUFACTURE_REQUIRED)
    private Integer yearOfManufacture;

    /**
     * Manufacturer of the sold vehicle.
     * This field is required and represents the manufacturer of the vehicle.
     */
    @NotNull(message = SalesConstants.MANUFACTURED_BY_REQUIRED)
    private String manufacturedBy;

    /**
     * NIC of the buyer who purchased the vehicle.
     * This field is required and represents the buyer's NIC.
     */
    @NotNull(message = SalesConstants.BUYER_NIC_REQUIRED)
    private String buyerNIC;
}
