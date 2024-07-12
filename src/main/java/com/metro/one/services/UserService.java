package com.metro.one.services;

import com.metro.one.dto.request.LoginRequest;
import com.metro.one.dto.request.UserRequest;
import com.metro.one.dto.response.UserRegister;
import com.metro.one.dto.response.UserResponse;
import com.metro.one.entity.User;
import com.metro.one.utils.CrudMetroOne;
import reactor.core.publisher.Mono;

public interface UserService extends CrudMetroOne<User,Long> {

    Mono<UserRegister> register(UserRequest user);

    Mono<UserResponse> login(LoginRequest login);
}
