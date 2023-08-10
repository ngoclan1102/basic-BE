package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="product_oder")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_oder")
    private Long idProductOder;

    @Column(name = "id_oder")
    private Long idOrder;

    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "quantity")
    private Long quantity;
}
