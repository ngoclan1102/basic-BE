package com.shop.be.service;

import com.shop.be.rp.AccountDetailRp;
import com.shop.be.rq.AccountRq;
import com.shop.be.rq.CreateAccountRq;

public interface IAccountService {
    String createAccount(CreateAccountRq rq);

    AccountDetailRp accountDetail(AccountRq rq);

    String login(AccountRq rq);

    String logout(AccountRq rq);
}
