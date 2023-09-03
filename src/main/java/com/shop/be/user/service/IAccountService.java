package com.shop.be.user.service;

import com.shop.be.user.rp.AccountDetailRp;
import com.shop.be.user.rq.AccountRq;
import com.shop.be.user.rq.CreateAccountRq;

public interface IAccountService {
    String createAccount(CreateAccountRq rq);

    AccountDetailRp accountDetail(AccountRq rq);

    String login(AccountRq rq);

    String logout(AccountRq rq);
}
