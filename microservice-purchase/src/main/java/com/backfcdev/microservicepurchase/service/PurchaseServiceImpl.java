package com.backfcdev.microservicepurchase.service;

import com.backfcdev.microservicepurchase.model.Purchase;
import com.backfcdev.microservicepurchase.repository.IPurchaseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements IPurchaseService{

    private final IPurchaseRepository purchaseRepository;


    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase save(Purchase purchase) {
        purchase.setPurchaseDate(LocalDateTime.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Purchase update(Long id, Purchase purchase) {
        purchaseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return purchaseRepository.save(purchase);
    }

    @Override
    public void delete(Long id) {
        purchaseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        purchaseRepository.deleteById(id);
    }

    @Override
    public List<Purchase> findAllPurchasesOfUser(Long userId) {
        return purchaseRepository.findAllByUserId(userId);
    }
}
