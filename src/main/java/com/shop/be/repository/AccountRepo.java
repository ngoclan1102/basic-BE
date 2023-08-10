package com.shop.be.repository;

import com.shop.be.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
    @Query(nativeQuery = true, value = "select * from account where user_name := user_name")
    Account findAccountByUserName(@Param("user_name") String userName);
    @Query(nativeQuery = true, value = "select * from account where password := password")
    Account findAccountByPassword(@Param("password") String password);
}
