package com.shop.be.user.service;

import com.shop.be.user.rp.ProductDetail;
import com.shop.be.user.rq.ProductRq;

import java.util.List;

public interface IProductService {
    List<ProductDetail> listProduct();

    ProductDetail detail(ProductRq rq);
}
