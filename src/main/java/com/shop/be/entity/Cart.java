package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Long idCart;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "id_product")
    private String idProduct;
}
