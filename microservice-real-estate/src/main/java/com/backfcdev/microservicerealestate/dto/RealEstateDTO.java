package com.backfcdev.microservicerealestate.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RealEstateDTO {

    private Long id;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String direction;

    @Column(length = 1200)
    private String picture;

    @Column(nullable = false)
    private Double price;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;
}
