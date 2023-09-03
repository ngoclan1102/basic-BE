package com.shop.be.login;

import lombok.Data;

@Data
public class LoginRp {

    private Long idUser;

    private String role;

    private String username;

    private String password;
}
