package com.backfcdev.apigateway.controller;

import com.backfcdev.apigateway.model.User;
import com.backfcdev.apigateway.service.AuthenticationService;
import com.backfcdev.apigateway.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    private final IUserService userService;


    @PostMapping("/sign-up")
    ResponseEntity<?> signUp(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()).isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.save(user));
    }

    @PostMapping("/sign-in")
    ResponseEntity<?> signIn(@RequestBody User user){
        return ResponseEntity.ok(authenticationService.signInAndReturnJWT(user));
    }

}
