package com.backfcdev.apigateway.service.impl;

import com.backfcdev.apigateway.dto.AuthRequest;
import com.backfcdev.apigateway.dto.AuthResponse;
import com.backfcdev.apigateway.model.User;
import com.backfcdev.apigateway.security.UserPrincipal;
import com.backfcdev.apigateway.security.jwt.JwtProvider;
import com.backfcdev.apigateway.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    @Override
    public AuthResponse signInAndReturnJWT(AuthRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        return new AuthResponse(jwt);
    }
}