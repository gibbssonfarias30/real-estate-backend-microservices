package com.backfcdev.microservicepurchase.service;

import com.backfcdev.microservicepurchase.model.Purchase;

import java.util.List;

public interface IPurchaseService {

    Purchase save(Purchase purchase);
    List<Purchase> findAllPurchasesOfUser(Long userId);
}