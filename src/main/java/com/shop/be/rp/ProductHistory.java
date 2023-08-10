package com.shop.be.rp;

import lombok.Data;

@Data
public class ProductHistory {
    private String nameProduct;

    private String price;

    private Integer quantity;

    private String response;
}
