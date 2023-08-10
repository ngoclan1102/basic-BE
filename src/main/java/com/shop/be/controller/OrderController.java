package com.shop.be.controller;

import com.shop.be.rp.ListOrderHistory;
import com.shop.be.rq.OrderRq;
import com.shop.be.rq.ProductRq;
import com.shop.be.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    public ResponseEntity<List<ListOrderHistory>> listOrder(@RequestBody ProductRq rq) {
        return  new ResponseEntity<>(orderService.listOrder(rq), HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<ListOrderHistory> detailOrder(@RequestBody OrderRq rq) {
        return  new ResponseEntity<>(orderService.detailOrderHistory(rq), HttpStatus.OK);
    }
}
