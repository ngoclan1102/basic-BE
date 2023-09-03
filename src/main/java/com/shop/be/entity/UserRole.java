package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_role")
    private Long idUserRole;

    @Column(name = "id_account")
    private Long idAccount;

    @Column(name = "id_role")
    private Long idRole;
}
