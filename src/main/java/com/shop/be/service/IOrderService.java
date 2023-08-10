package com.shop.be.service;

import com.shop.be.rp.ListOrderHistory;
import com.shop.be.rq.OrderRq;
import com.shop.be.rq.ProductRq;

import java.util.List;

public interface IOrderService {
    List<ListOrderHistory> listOrder(ProductRq rq);

    ListOrderHistory detailOrderHistory(OrderRq rq);
}
