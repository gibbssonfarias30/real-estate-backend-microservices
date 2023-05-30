package com.backfcdev.apigateway.controller;

import com.backfcdev.apigateway.dto.AuthRequest;
import com.backfcdev.apigateway.dto.AuthResponse;
import com.backfcdev.apigateway.dto.UserDTO;
import com.backfcdev.apigateway.model.User;
import com.backfcdev.apigateway.service.IAuthenticationService;
import com.backfcdev.apigateway.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private final IAuthenticationService authenticationService;

    private final IUserService userService;

    private final ModelMapper mapper;


    @PostMapping("/sign-up")
    ResponseEntity<UserDTO> signUp(@RequestBody UserDTO user){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertToDto(userService.save(convertToEntity(user))));
    }

    @PostMapping("/sign-in")
    ResponseEntity<AuthResponse> signIn(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authenticationService.signInAndReturnJWT(authRequest));
    }


    private UserDTO convertToDto(User entity){
        return mapper.map(entity, UserDTO.class);
    }

    private User convertToEntity(UserDTO dto){
        return mapper.map(dto, User.class);
    }
}
