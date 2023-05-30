package com.backfcdev.apigateway.model;

import com.backfcdev.apigateway.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    @Column(name="created_date")
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;

}
