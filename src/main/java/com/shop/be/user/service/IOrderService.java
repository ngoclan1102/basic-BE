package com.shop.be.user.service;

import com.shop.be.user.rp.ListOrderHistory;
import com.shop.be.user.rq.OrderRq;
import com.shop.be.user.rq.ProductRq;

import java.util.List;

public interface IOrderService {
    List<ListOrderHistory> listOrder(ProductRq rq);

    ListOrderHistory detailOrderHistory(OrderRq rq);
}
