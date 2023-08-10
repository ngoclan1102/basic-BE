package com.shop.be.rp;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ListOrderHistory {

    private List<ProductHistory> product;

    private String totalMoney;

    private String shipping;

    private Integer status;

    private LocalDateTime startDate;

    private String receiveDate;

    private String address;

    private String city;

    private String response;
}
