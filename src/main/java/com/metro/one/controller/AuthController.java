package com.metro.one.controller;

import com.metro.one.controller.api.AuthApi;
import com.metro.one.dto.request.LoginRequest;
import com.metro.one.dto.request.UserRequest;
import com.metro.one.dto.response.UserRegister;
import com.metro.one.dto.response.UserResponse;
import com.metro.one.services.UserService;

import static com.metro.one.utils.endpoints.ApiVersion.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(V1 + "auth")
public class AuthController implements AuthApi {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Mono<UserRegister>> create(UserRequest userRequest) {
        return new ResponseEntity<>(userService.register(userRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Mono<UserResponse>> login(LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
