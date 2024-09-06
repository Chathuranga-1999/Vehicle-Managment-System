package com.Vehicle_management_system.service_record_service.service.implementation;

import com.Vehicle_management_system.service_record_service.model.ServiceRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * This service class provides methods to interact with external APIs related to service records.
 * It uses a RestTemplate to make HTTP requests to an external service to fetch service record data.
 */

@Service

public class ApiServiceImpl {

    private RestTemplate restTemplate;

    /**
     * Fetches a ServiceRecord by its ID from an external API.
     *
     * @param id the ID of the service record to fetch
     * @return the ServiceRecord object retrieved from the external API
     */

    public ServiceRecord getServiceRecordById(Long id) {
        String url = "http://localhost:8081/api/services/records/" + id;
        return restTemplate.getForObject(url, ServiceRecord.class);
    }
}