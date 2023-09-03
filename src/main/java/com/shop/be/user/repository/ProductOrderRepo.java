package com.shop.be.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.be.entity.ProductOrder;

@Repository
public interface ProductOrderRepo extends JpaRepository<ProductOrder, Long> {
}
