package com.backfcdev.microservicepurchase.controller;

import com.backfcdev.microservicepurchase.dto.PurchaseDTO;
import com.backfcdev.microservicepurchase.model.Purchase;
import com.backfcdev.microservicepurchase.service.IPurchaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;


    @GetMapping
    ResponseEntity<List<PurchaseDTO>> findAll(){
        return ResponseEntity.ok(purchaseService.findAll()
                .stream()
                .map(this::convertToDto)
                .toList());
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody PurchaseDTO dto){
        Purchase purchase = purchaseService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(purchase.getId()).toUri();
        log.info("purchase created {}", purchase.getTitle());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<PurchaseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(convertToDto(purchaseService.findById(id)));
    }

    @PutMapping("/{id}")
    ResponseEntity<PurchaseDTO> update(@PathVariable Long id, @RequestBody PurchaseDTO dto ){
        return ResponseEntity.ok(convertToDto(purchaseService.update(id, convertToEntity(dto))));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        purchaseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/{userId}")
    ResponseEntity<List<PurchaseDTO>> getAllPurchasesOfUser(@PathVariable Long userId){
        return ResponseEntity.ok(purchaseService.findAllPurchasesOfUser(userId)
                .stream()
                .map(this::convertToDto)
                .toList());
    }



    private PurchaseDTO convertToDto(Purchase entity){
        return mapper.map(entity, PurchaseDTO.class);
    }

    private Purchase convertToEntity(PurchaseDTO dto){
        return mapper.map(dto, Purchase.class);
    }
}
