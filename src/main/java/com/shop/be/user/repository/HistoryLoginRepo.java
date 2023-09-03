package com.shop.be.user.repository;

import com.shop.be.entity.HistoryLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryLoginRepo extends JpaRepository<HistoryLogin, Long> {

    @Query(nativeQuery = true, value = "select * from history_login where id_user := id_user")
    HistoryLogin findByIdUser(@Param("id_user") Long idUser);
}
