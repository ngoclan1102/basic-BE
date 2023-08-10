package com.shop.be.rp;

import lombok.Data;

@Data
public class ProductDetail {
    private Long idCategory;

    private String nameProduct;

    private String color;

    private String quantitySold;

    private String total;

    private Integer status;

    private String img;

    private String price;

    private String discount;

    private String startDateDiscount;

    private String endDateDiscount;

    private String description;

    private String response;
}
