package com.shop.be.user.controller;

import com.shop.be.user.rp.ProductDetail;
import com.shop.be.user.rq.ProductRq;
import com.shop.be.user.service.IWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
    @Autowired
    private IWishlistService wishlistService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDetail>> listWishlist(@RequestBody ProductRq rq) {
        return new ResponseEntity<>(wishlistService.wishlist(rq), HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<String> deleteWishlist(@RequestBody ProductRq rq) {
        return new ResponseEntity<>(wishlistService.deleteProduct(rq), HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<String> addWishlist(@RequestBody ProductRq rq) {
        return new ResponseEntity<>(wishlistService.addWishlist(rq), HttpStatus.OK);
    }


}
