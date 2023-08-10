package com.shop.be.service;

import com.shop.be.rp.ProductDetail;
import com.shop.be.rq.ProductRq;

import java.util.List;

public interface IProductService {
    List<ProductDetail> listProduct();

    ProductDetail detail(ProductRq rq);
}
