package com.backfcdev.apigateway.service;

import com.backfcdev.apigateway.enums.Role;
import com.backfcdev.apigateway.model.User;

import java.util.Optional;

public interface IUserService {
    User save(User user);
    Optional<User> findByUsername(String username);
    void changeRole(Role newRole, String username);
}
