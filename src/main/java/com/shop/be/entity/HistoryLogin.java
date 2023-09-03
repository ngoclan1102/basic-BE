package com.shop.be.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table(name="history-login")
public class HistoryLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_history_login")
    private Long idHistoryLogin;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "start_login")
    private LocalDateTime startLogin;
}
