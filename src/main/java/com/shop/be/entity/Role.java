package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "role_name")
    private String nameRole;
}
