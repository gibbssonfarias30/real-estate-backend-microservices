package com.backfcdev.microservicepurchase.repository;

import com.backfcdev.microservicepurchase.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findAllByUserId(Long userId);
}