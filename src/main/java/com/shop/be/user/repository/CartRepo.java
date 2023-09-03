package com.shop.be.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.shop.be.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    @Query(nativeQuery = true, value = "select * from cart where cart.id_account =: id_account")
    Cart findCartByIdAccount(@Param("id_account") Long idAccount);
}
