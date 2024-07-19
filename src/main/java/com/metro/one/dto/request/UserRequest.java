package com.metro.one.dto.request;

import com.metro.one.entity.User;
import lombok.Builder;
import lombok.Data;
import reactor.core.publisher.Mono;


@Data
@Builder
public class UserRequest {

    private String name;

    private String lastName;

    private String documentType;

    private String documentNumber;

    private String password;

    private Integer phone;

    private String email;

    private Long cardNumber;


    public static Mono<User> toEntity(UserRequest userRequest) {
        return Mono.justOrEmpty(userRequest)
                .switchIfEmpty(Mono.error(new RuntimeException("UserRequest is null")))
                .map(request -> User.builder()
                        .name(request.getName())
                        .lastName(request.getLastName())
                        .documentType(userRequest.getDocumentType())
                        .documentNumber(request.getDocumentNumber())
                        .password(request.getPassword())
                        .phone(request.getPhone())
                        .email(request.getEmail())
                        .cardNumber(request.getCardNumber())
                        .build());
    }

    public static Mono<UserRequest> fromEntity(User user) {
        return Mono.justOrEmpty(user)
                .switchIfEmpty(Mono.error(new RuntimeException("User is null")))
                .map(currentUser -> UserRequest.builder()
                        .name(currentUser.getName())
                        .lastName(currentUser.getLastName())
                        .documentType(currentUser.getDocumentType())
                        .password(currentUser.getPassword())
                        .phone(currentUser.getPhone())
                        .email(currentUser.getEmail())
                        .cardNumber(currentUser.getCardNumber())
                        .build());

    }

}
