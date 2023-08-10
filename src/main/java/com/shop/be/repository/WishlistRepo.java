package com.shop.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.be.entity.Wishlist;

@Repository
public interface WishlistRepo extends JpaRepository<Wishlist, Long> {
    Wishlist getByIdAccount(Long idAccount);
}
