package com.metro.one.services.impl;

import com.metro.one.dto.request.LoginRequest;
import com.metro.one.dto.request.UserRequest;
import com.metro.one.dto.response.UserResponse;
import com.metro.one.entity.User;
import com.metro.one.repository.UserRepository;
import com.metro.one.services.UserService;
import com.metro.one.utils.enums.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Mono<User> register(UserRequest userDto) {
        Mono<User> userRequest = UserRequest.toEntity(userDto);
        return userRequest.flatMap(userEntity -> {
            Mono<Boolean> booleanMono = userRepository.existsByDocumentNumberOrCardNumberOrEmail(userEntity.getDocumentNumber(), userEntity.getCardNumber(), userEntity.getEmail());
            return booleanMono.flatMap(exists -> {
                if (exists) {
                    return Mono.error(new RuntimeException("User already exists by document number, card number or email"));
                }
                userEntity.setRole(UserRoleEnum.USER.name());
                return userRepository.save(userEntity);
            });
        });
    }

    @Override
    public Mono<UserResponse> login(LoginRequest login) {
        Mono<User> userMono = userRepository.findByDocumentNumberAndPassword(login.getDni(), login.getPassword());
        return userMono.switchIfEmpty(Mono.error(new RuntimeException("User Or Password Incorrect")))
                .flatMap( x -> Mono.just(UserResponse.builder().bearer("bearer").token("token").build()));
    }
}
