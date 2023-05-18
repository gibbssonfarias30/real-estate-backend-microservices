package com.backfcdev.microservicepurchase.controller;

import com.backfcdev.microservicepurchase.model.Purchase;
import com.backfcdev.microservicepurchase.service.IPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/purchases")
public class PurchaseController {

    private final IPurchaseService purchaseService;

    @PostMapping
    ResponseEntity<Void> save(@RequestBody Purchase purchase){
        Purchase purchaseCreated = purchaseService.save(purchase);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(purchaseCreated.getId()).toUri();
        log.info("purchase created {}", purchase.getTitle());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{userId}")
    ResponseEntity<List<Purchase>> getAllPurchasesOfUser(@PathVariable Long userId){
        return ResponseEntity.ok(purchaseService.findAllPurchasesOfUser(userId));
    }
}
