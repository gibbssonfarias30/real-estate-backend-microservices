package com.backfcdev.apigateway.controller;


import com.backfcdev.apigateway.request.IRealEstateServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/gateway/real-estate")
public class RealEstateController {

    private final IRealEstateServiceRequest realEstateServiceRequest;


    @PostMapping
    ResponseEntity<?> saveRealEstate(@RequestBody Object realEstate){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(realEstateServiceRequest.saveRealEstate(realEstate));
    }

    @DeleteMapping("/{realEstateId}")
    ResponseEntity<?> deleteRealEstate(@PathVariable Long realEstateId){
        realEstateServiceRequest.deleteRealEstate(realEstateId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<?> getAllRealEstates(){
        return ResponseEntity.ok(realEstateServiceRequest.getAllRealEstates());
    }
}
