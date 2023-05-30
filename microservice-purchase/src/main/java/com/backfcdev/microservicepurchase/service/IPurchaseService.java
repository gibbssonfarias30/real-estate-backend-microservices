package com.backfcdev.microservicepurchase.service;

import com.backfcdev.microservicepurchase.model.Purchase;

import java.util.List;

public interface IPurchaseService {

    List<Purchase> findAll();

    Purchase save(Purchase purchase);

    Purchase findById(Long id);

    Purchase update(Long id, Purchase purchase);

    void delete(Long id);

    List<Purchase> findAllPurchasesOfUser(Long userId);
}