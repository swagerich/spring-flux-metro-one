package com.metro.one.controller;

import com.metro.one.dto.request.LoginRequest;
import com.metro.one.dto.request.UserRequest;
import com.metro.one.dto.response.UserResponse;
import com.metro.one.entity.User;
import com.metro.one.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Mono<User>> create(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.register(userRequest), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Mono<UserResponse>> login (@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.login(loginRequest));
    }
}
