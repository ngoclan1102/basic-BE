package com.shop.be.service.Impl;

import com.shop.be.Constant.Constant;
import com.shop.be.rq.ProductRq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.entity.Wishlist;
import com.shop.be.repository.ProductRepo;
import com.shop.be.repository.WishlistRepo;
import com.shop.be.rp.ProductDetail;
import com.shop.be.service.IWishlistService;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistServiceImpl implements IWishlistService {

    @Autowired
    private WishlistRepo wishlistRepo;

    @Autowired
    private ProductRepo productRepo;

    private final ModelMapper mapper = new ModelMapper();

    private List<Long> getIds(String []ids){
        List<Long> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(Long.parseLong(id));
        }

        return idList;
    }

    @Override
    public List<ProductDetail> wishlist(ProductRq rq) {
        List<Long> ids = getIds(wishlistRepo.getByIdAccount(rq.getIdAccount()).getIdProduct().split(","));
        List<ProductDetail> products = new ArrayList<>();
        productRepo.findAllById(ids).forEach(p -> products.add(mapper.map(p, ProductDetail.class)));
        return products;
    }

    @Override
    public String deleteProduct(ProductRq rq) {
        List<Long> ids = getIds(wishlistRepo.getByIdAccount(rq.getIdAccount()).getIdProduct().split(","));
        if (!ids.contains(rq.getIdProduct())) {
            return Constant.Product.findAccountFail;
        }

        try {
            Wishlist wishlist = wishlistRepo.getByIdAccount(rq.getIdAccount());
            wishlist.setIdProduct(wishlist.getIdProduct().replace(rq.getIdProduct().toString() + ",", ""));
            wishlistRepo.save(wishlist);
        }catch (Exception e) {
            return Constant.Wishlist.deleteWishlistFail;
        }

        return Constant.Success;
    }

    @Override
    public String addWishlist(ProductRq rq) {
        try {
            Wishlist wishlist = wishlistRepo.getByIdAccount(rq.getIdAccount());
            try {
                wishlist.setIdProduct(wishlist.getIdProduct() + rq.getIdProduct().toString() + ",");
                wishlistRepo.save(wishlist);
            }catch (Exception e) {
                return Constant.Wishlist.addWishlistFail;
            }
        }catch (Exception e) {
            return Constant.Account.findAccountFail;
        }
        return Constant.Success;
    }
}
