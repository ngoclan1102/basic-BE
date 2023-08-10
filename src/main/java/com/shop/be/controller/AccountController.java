package com.shop.be.controller;

import com.shop.be.rp.AccountDetailRp;
import com.shop.be.rq.AccountRq;
import com.shop.be.rq.CreateAccountRq;
import com.shop.be.service.IAccountService;
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

    @PostMapping("/crete")
    public ResponseEntity<String> create(@RequestBody CreateAccountRq rq) {
        return new ResponseEntity<>(accountService.createAccount(rq), HttpStatus.OK);
    }
}
