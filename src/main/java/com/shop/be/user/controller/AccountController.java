package com.shop.be.user.controller;

import com.shop.be.user.rp.AccountDetailRp;
import com.shop.be.user.rq.AccountRq;
import com.shop.be.user.rq.CreateAccountRq;
import com.shop.be.user.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("/detail")
    public ResponseEntity<AccountDetailRp> detail(@RequestBody AccountRq rq) {
        return new ResponseEntity<>(accountService.accountDetail(rq), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CreateAccountRq rq) {
        return new ResponseEntity<>(accountService.createAccount(rq), HttpStatus.OK);
    }
}
