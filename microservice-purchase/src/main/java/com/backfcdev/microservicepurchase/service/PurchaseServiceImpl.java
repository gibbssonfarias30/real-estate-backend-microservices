package com.backfcdev.microservicepurchase.service;

import com.backfcdev.microservicepurchase.model.Purchase;
import com.backfcdev.microservicepurchase.repository.IPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements IPurchaseService{

    private final IPurchaseRepository purchaseRepository;


    @Override
    public Purchase save(Purchase purchase) {
        purchase.setPurchaseDate(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> findAllPurchasesOfUser(Long userId) {
        return purchaseRepository.findAllByUserId(userId);
    }
}
