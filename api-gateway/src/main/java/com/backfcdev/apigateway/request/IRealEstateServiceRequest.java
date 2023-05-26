package com.backfcdev.apigateway.request;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        value = "real-estate-service",
        path = "/api/v1/real-estate",
        //url = "${real-estate.service.url}",
        configuration = FeignConfiguration.class
)
public interface IRealEstateServiceRequest {

    @PostMapping
    Object saveRealEstate(@RequestBody Object requestBody);

    @DeleteMapping("/{realEstateId}")
    void deleteRealEstate(@PathVariable Long realEstateId);

    @GetMapping
    List<Object> getAllRealEstates();
}
