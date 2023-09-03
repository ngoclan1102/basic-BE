package com.shop.be.user.rq;

import lombok.Data;

@Data
public class AccountRq {
    private Long idAccount;

    private String userName;

    private String password;
}
