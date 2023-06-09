package com.backfcdev.microservicepurchase.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "real_estate_id")
    private Long realEstateId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double price;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

}
