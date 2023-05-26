package com.backfcdev.apigateway.controller;


import com.backfcdev.apigateway.request.IPurchaseServiceRequest;
import com.backfcdev.apigateway.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/gateway/purchases")
public class PurchaseController {

    private final IPurchaseServiceRequest purchaseServiceRequest;


    @PostMapping
    ResponseEntity<?> savePurchase(@RequestBody Object purchase){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(purchaseServiceRequest.savePurchase(purchase));
    }


    @GetMapping
    ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return ResponseEntity.ok(purchaseServiceRequest.getAllPurchasesOfUser(userPrincipal.getId()));
    }
}
