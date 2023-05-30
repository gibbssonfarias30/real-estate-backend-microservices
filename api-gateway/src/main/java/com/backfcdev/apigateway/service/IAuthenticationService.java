package com.backfcdev.apigateway.service;

import com.backfcdev.apigateway.dto.AuthRequest;
import com.backfcdev.apigateway.dto.AuthResponse;

public interface IAuthenticationService {
    AuthResponse signInAndReturnJWT(AuthRequest signInRequest);
}