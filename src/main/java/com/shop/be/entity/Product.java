package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "id_category")
    private Long idCategory;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "id_color")
    private Long idColor;

    @Column(name = "quantity_sold")
    private String quantitySold;

    @Column(name = "total")
    private String total;

    @Column(name = "status")
    private Integer status;

    @Column(name = "img")
    private String img;

    @Column(name = "price")
    private String price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "start_date_discount")
    private String startDateDiscount;

    @Column(name = "end_date_discount")
    private String endDateDiscount;

    @Column(name = "description")
    private String description;

    @Column(name = "delete_flag")
    private Integer deleteFlag;
}
