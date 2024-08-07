package com.metro.one.services.impl;

import com.metro.one.dto.request.LoginRequest;
import com.metro.one.dto.request.UserRequest;
import com.metro.one.dto.response.UserRegister;
import com.metro.one.dto.response.UserResponse;
import com.metro.one.entity.TransportCard;
import com.metro.one.exception.BadRequestException;
import com.metro.one.repository.TransportCardRepository;
import com.metro.one.repository.UserRepository;
import com.metro.one.security.jwt.JwtProvider;
import com.metro.one.services.UserService;
import com.metro.one.utils.enums.UserRoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final TransportCardRepository transportCardRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProvider jwtProvider;

    @Override
    public Mono<UserRegister> register(UserRequest userDto) {
        return Mono.just(userDto).flatMap(UserRequest::toEntity).flatMap(user -> userRepository.existsByDocumentNumberOrCardNumberOrEmail(user.getDocumentNumber(), user.getCardNumber(), user.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new BadRequestException("User already exists by document number, card number or email"));
                    }
                    user.setRoles(UserRoleEnum.USER.name());
                    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
                    return userRepository.save(user)
                            .flatMap(savedUser -> {
                                var transportCard = TransportCard.builder()
                                        .userId(savedUser.getUserId())
                                        .balance(BigDecimal.ZERO)
                                        .cardNumber(savedUser.getCardNumber())
                                        .build();
                                return transportCardRepository.save(transportCard)
                                        .map(card -> UserRegister.builder().cardNumberId(card.getTransportCardId()).build());
                            });

                }));
    }

    @Override
    public Mono<UserResponse> login(LoginRequest login) {
        return userRepository.findByDocumentNumber(login.getDni())
                .switchIfEmpty(Mono.error(new BadRequestException("User Dni Or Password Incorrect")))
                .filter(user -> passwordEncoder.matches(login.getPassword(), user.getPassword()))
                .map(jwtProvider::generateToken)
                .map(token -> UserResponse.builder().token(token).bearer("bearer").build());

    }
}
