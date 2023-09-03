package com.shop.be.user.service;

import com.shop.be.user.rp.ListProductOfCartRp;
import com.shop.be.user.rq.ProductRq;
import com.shop.be.user.rq.ListCartRq;

import java.util.List;

public interface ICartService {
    List<ListProductOfCartRp> listProduct(ListCartRq rq);

    String addToCart(ProductRq rq);

    String deleteProductOfCart(ProductRq rq);
}
