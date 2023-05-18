package com.backfcdev.microservicerealestate.service;

import com.backfcdev.microservicerealestate.model.RealEstate;

import java.util.List;

public interface IRealEstateService {

    List<RealEstate> findAll();
    RealEstate save(RealEstate realEstate);
    RealEstate findById(Long id);
    void delete(Long id);
}
