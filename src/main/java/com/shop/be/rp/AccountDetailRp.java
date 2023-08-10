package com.shop.be.rp;

import lombok.Data;

@Data
public class AccountDetailRp {
    private String userName;

    private String phone;

    private String email;

    private String address;

    private Integer sex;

    private String response;
}
