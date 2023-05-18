package com.backfcdev.microservicerealestate.repository;

import com.backfcdev.microservicerealestate.model.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRealEstateRepository extends JpaRepository<RealEstate, Long> {
}
