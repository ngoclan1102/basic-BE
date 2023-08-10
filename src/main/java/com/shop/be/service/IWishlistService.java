package com.shop.be.service;

import com.shop.be.rp.ProductDetail;
import com.shop.be.rq.ProductRq;

import java.util.List;

public interface IWishlistService {
    List<ProductDetail> wishlist(ProductRq rq);

    String deleteProduct(ProductRq rq);

    String addWishlist(ProductRq rq);
}
