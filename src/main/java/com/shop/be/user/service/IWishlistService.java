package com.shop.be.user.service;

import com.shop.be.user.rp.ProductDetail;
import com.shop.be.user.rq.ProductRq;

import java.util.List;

public interface IWishlistService {
    List<ProductDetail> wishlist(ProductRq rq);

    String deleteProduct(ProductRq rq);

    String addWishlist(ProductRq rq);
}
