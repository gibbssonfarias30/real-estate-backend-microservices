package com.backfcdev.microservicerealestate.controller;

import com.backfcdev.microservicerealestate.model.RealEstate;
import com.backfcdev.microservicerealestate.service.IRealEstateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/real-estate")
public class RealEstateController {

    private final IRealEstateService realEstateService;

    @GetMapping
    ResponseEntity<List<RealEstate>> findAll(){
        return ResponseEntity.ok(realEstateService.findAll());
    }
    @PostMapping
    ResponseEntity<Void> save(@RequestBody RealEstate realEstate){
        RealEstate realEstateCreated = realEstateService.save(realEstate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(realEstateCreated.getId()).toUri();
        log.info("real estate saved: {}", realEstateCreated);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<RealEstate> findById(@PathVariable Long id){
        return ResponseEntity.ok(realEstateService.findById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        realEstateService.delete(id);
        return ResponseEntity.noContent().build();
    }


}