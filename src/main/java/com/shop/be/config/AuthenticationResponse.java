package com.shop.be.config;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationResponse {

    private String token;
}
