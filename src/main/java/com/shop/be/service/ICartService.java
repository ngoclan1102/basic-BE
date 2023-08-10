package com.shop.be.service;

import com.shop.be.rp.ListProductOfCartRp;
import com.shop.be.rq.ProductRq;
import com.shop.be.rq.ListCartRq;

import java.util.List;

public interface ICartService {
    List<ListProductOfCartRp> listProduct(ListCartRq rq);

    String addToCart(ProductRq rq);

    String deleteProductOfCart(ProductRq rq);
}
