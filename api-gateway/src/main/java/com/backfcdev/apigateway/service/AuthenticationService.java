package com.backfcdev.apigateway.service;

import com.backfcdev.apigateway.model.User;

public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}