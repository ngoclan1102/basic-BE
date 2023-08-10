package com.shop.be.rp;

import lombok.Data;

@Data
public class ListProductOfCartRp {
    private String nameProduct;

    private String img;

    private String price;

    private String discount;

    private String response;
}
