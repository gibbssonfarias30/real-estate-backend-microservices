package com.backfcdev.apigateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(
        value = "purchase-service",
        path = "/api/v1/purchases",
        url = "${purchase.service.url}",
        configuration = FeignConfiguration.class
)
public interface IPurchaseServiceRequest {

    @PostMapping
    Object savePurchase(@RequestBody Object requestBody);

    @GetMapping("/{userId}")
    List<Object> getAllPurchasesOfUser(@PathVariable Long userId);


}
