package com.metro.one.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String dni;

    private String password;
}
