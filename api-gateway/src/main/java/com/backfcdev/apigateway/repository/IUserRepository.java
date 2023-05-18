package com.backfcdev.apigateway.repository;

import com.backfcdev.apigateway.enums.Role;
import com.backfcdev.apigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update USER set role=:role WHERE username=:username")
    void updateUserRole(@Param("username") String username, @Param("role") Role role);
}