package com.backfcdev.microservicerealestate.controller;

import com.backfcdev.microservicerealestate.dto.RealEstateDTO;
import com.backfcdev.microservicerealestate.model.RealEstate;
import com.backfcdev.microservicerealestate.service.IRealEstateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;


    @GetMapping
    ResponseEntity<List<RealEstateDTO>> findAll(){
        return ResponseEntity.ok(realEstateService.findAll()
                .stream()
                .map(this::convertToDto)
                .toList());
    }

    @PostMapping
    ResponseEntity<Void> save(@RequestBody RealEstateDTO dto){
        RealEstate realEstate = realEstateService.save(convertToEntity(dto));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(realEstate.getId()).toUri();
        log.info("real estate saved: {}", realEstate);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<RealEstateDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(convertToDto(realEstateService.findById(id)));
    }

    @PutMapping("/{id}")
    ResponseEntity<RealEstateDTO> update(@PathVariable Long id, @RequestBody RealEstateDTO dto ){
        return ResponseEntity.ok(convertToDto(realEstateService.update(id, convertToEntity(dto))));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id){
        realEstateService.delete(id);
        return ResponseEntity.noContent().build();
    }



    private RealEstateDTO convertToDto(RealEstate entity){
        return mapper.map(entity, RealEstateDTO.class);
    }

    private RealEstate convertToEntity(RealEstateDTO dto){
        return mapper.map(dto, RealEstate.class);
    }
}