package com.backfcdev.microservicerealestate.service;

import com.backfcdev.microservicerealestate.exception.EntityNotFoundException;
import com.backfcdev.microservicerealestate.model.RealEstate;
import com.backfcdev.microservicerealestate.repository.IRealEstateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class RealEstateServiceImpl implements IRealEstateService{

    private final IRealEstateRepository realEstateRepository;


    @Override
    public List<RealEstate> findAll() {
        return realEstateRepository.findAll();
    }

    @Override
    public RealEstate save(RealEstate realEstate) {
        realEstate.setCreatedDate(LocalDateTime.now());
        return realEstateRepository.save(realEstate);
    }

    @Override
    public RealEstate findById(Long id) {
        return realEstateRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        realEstateRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        realEstateRepository.deleteById(id);
    }
}
