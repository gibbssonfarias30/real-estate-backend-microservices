package com.backfcdev.apigateway.dto;

import com.backfcdev.apigateway.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;

    @Column(unique=true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(name="created_date", nullable = false)
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Transient
    private String token;
}
