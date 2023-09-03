package com.shop.be.user.controller;

import com.shop.be.user.rp.ListProductOfCartRp;
import com.shop.be.user.rq.ProductRq;
import com.shop.be.user.rq.ListCartRq;
import com.shop.be.user.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/list")
    public ResponseEntity<List<ListProductOfCartRp>> listProduct(@RequestBody ListCartRq rq) {
        return new ResponseEntity<>(cartService.listProduct(rq), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductRq rq) {
        return new ResponseEntity<>(cartService.addToCart(rq), HttpStatus.OK);
    }

    @PutMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody ProductRq rq) {
        return new ResponseEntity<>(cartService.deleteProductOfCart(rq), HttpStatus.OK);
    }
}
