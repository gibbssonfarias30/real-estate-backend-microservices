package com.backfcdev.microservicepurchase.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class PurchaseDTO {

    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "real_estate_id", nullable = false)
    private Long realEstateId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

    @Column(name = "purchase_date", nullable = false)
    private LocalDateTime purchaseDate;
}
