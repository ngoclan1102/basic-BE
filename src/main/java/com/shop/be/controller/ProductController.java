package com.shop.be.controller;

import com.shop.be.rp.ProductDetail;
import com.shop.be.rq.ProductRq;
import com.shop.be.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDetail>> listOrder() {
        return new ResponseEntity<>(productService.listProduct(), HttpStatus.OK);
    }

        @GetMapping("/detail")
    public ResponseEntity<ProductDetail> detailOrder(@RequestBody ProductRq rq) {
        return new ResponseEntity<>(productService.detail(rq), HttpStatus.OK);
    }


}
