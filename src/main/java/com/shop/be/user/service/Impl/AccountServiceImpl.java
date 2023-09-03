package com.shop.be.user.service.Impl;

import com.shop.be.user.service.IAccountService;
import com.shop.be.Constant.Constant;
import com.shop.be.entity.Cart;
import com.shop.be.entity.Wishlist;
import com.shop.be.user.repository.CartRepo;
import com.shop.be.user.repository.WishlistRepo;
import com.shop.be.user.rp.AccountDetailRp;
import com.shop.be.user.rq.AccountRq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.entity.Account;
import com.shop.be.user.repository.AccountRepo;
import com.shop.be.user.rq.CreateAccountRq;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private WishlistRepo wishlistRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public String createAccount(CreateAccountRq rq) {
        try {
            Account account = mapper.map(rq, Account.class);
            account.setCreateTime(LocalDateTime.now());
            account.setStatus(0);
            accountRepo.save(account);
            try {
                Cart cart = new Cart();
                cart.setIdAccount(account.getIdAccount());
                cart.setIdProduct("");
                cartRepo.save(cart);
                try {
                    Wishlist wishlist = new Wishlist();
                    wishlist.setIdAccount(account.getIdAccount());
                    wishlist.setIdProduct("");
                    wishlistRepo.save(wishlist);
                }catch (Exception e) {
                    return Constant.Wishlist.createWishlistFail;
                }
            }catch (Exception e) {
                return Constant.Cart.createCartFail;
            }
        } catch (Exception e) {
            return Constant.Account.createFail;
        }

        return Constant.Success;
    }

    @Override
    public AccountDetailRp accountDetail(AccountRq rq) {
        AccountDetailRp detail = new AccountDetailRp();
        detail.setResponse(Constant.Account.findAccountFail);
        return accountRepo.findById(rq.getIdAccount()).isEmpty() ? detail :
                mapper.map(accountRepo.findById(rq.getIdAccount()), AccountDetailRp.class);
    }

    @Override
    public String login(AccountRq rq) {
        if ((accountRepo.findAccountByUserName(rq.getUserName()) == null ||
                accountRepo.findAccountByPassword(rq.getPassword()) == null) ||
                !(Objects.equals(accountRepo.findAccountByUserName(rq.getUserName()),
                        accountRepo.findAccountByPassword(rq.getPassword())))) {
            return Constant.Account.wrongAccount;
        }

        return Constant.Success;
    }

    @Override
    public String logout(AccountRq rq) {
        return null;
    }
}
