package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_color")
    private Long idColor;

    @Column(name = "name_color")
    private String nameColor;
}
