package com.metro.one.controller.api;

import com.metro.one.dto.request.LoginRequest;
import com.metro.one.dto.request.UserRequest;
import com.metro.one.dto.response.UserRegister;
import com.metro.one.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

public interface AuthApi {

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register a new user", description = "Register a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request Error registering user")
    })
    ResponseEntity<Mono<UserRegister>> create(@RequestBody UserRequest userRequest);


    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Login  user", description = "Login user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Login successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request Error login user")
    })
    ResponseEntity<Mono<UserResponse>> login(@RequestBody LoginRequest loginRequest);
}
