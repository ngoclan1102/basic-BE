package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="oder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oder")
    private Long idOrder;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "total_money")
    private String totalMoney;

    @Column(name = "shipping")
    private String shipping;

    @Column(name = "status")
    private Integer status;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "receive_date")
    private String receiveDate;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;
}
