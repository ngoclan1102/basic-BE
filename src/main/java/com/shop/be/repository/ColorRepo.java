package com.shop.be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.be.entity.Color;

@Repository
public interface ColorRepo extends JpaRepository<Color, Long> {
}
