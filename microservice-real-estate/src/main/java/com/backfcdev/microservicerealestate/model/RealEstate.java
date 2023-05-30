package com.backfcdev.microservicerealestate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "real_estate")
public class RealEstate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String direction;

    private String picture;

    private Double price;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
