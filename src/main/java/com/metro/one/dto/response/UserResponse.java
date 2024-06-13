package com.metro.one.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {

    private String token;

    private String bearer;
}
