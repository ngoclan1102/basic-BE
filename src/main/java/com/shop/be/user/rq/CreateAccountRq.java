package com.shop.be.user.rq;

import lombok.Data;

@Data
public class CreateAccountRq {
    private String userName;

    private String password;

    private String phone;

    private String email;
}
