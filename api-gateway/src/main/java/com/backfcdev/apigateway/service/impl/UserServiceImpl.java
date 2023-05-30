package com.backfcdev.apigateway.service.impl;

import com.backfcdev.apigateway.enums.Role;
import com.backfcdev.apigateway.exception.ExistsUsernameException;
import com.backfcdev.apigateway.model.User;
import com.backfcdev.apigateway.repository.IUserRepository;
import com.backfcdev.apigateway.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User save(User user) {
        User userCreated = User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(Role.USER)
                .createdDate(LocalDateTime.now())
                .build();
        if(userRepository.existsByUsername(userCreated.getUsername())) throw new ExistsUsernameException();

        return userRepository.save(userCreated);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }
}
