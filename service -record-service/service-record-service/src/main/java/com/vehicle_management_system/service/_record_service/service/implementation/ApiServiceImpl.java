package com.vehicle_management_system.service._record_service.service.implementation;

import com.vehicle_management_system.service._record_service.model.ServiceRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ApiServiceImpl {

    private RestTemplate restTemplate;

    public ServiceRecord getServiceRecordById(Long id) {
        String url = "http://localhost:8081/api/services/records/" + id;
        return restTemplate.getForObject(url, ServiceRecord.class);
    }
}
