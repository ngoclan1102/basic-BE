package com.shop.be.user.service.Impl;

import com.shop.be.user.rq.OrderRq;
import com.shop.be.user.rq.ProductRq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.entity.Order;
import com.shop.be.user.repository.OrderRepo;
import com.shop.be.user.repository.ProductOrderRepo;
import com.shop.be.user.rp.ListOrderHistory;
import com.shop.be.user.rp.ProductHistory;
import com.shop.be.user.service.IOrderService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductOrderRepo productOrderRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ListOrderHistory> listOrder(ProductRq rq) {
        List<Order> listOrder = orderRepo.findAllById(Collections.singleton(rq.getIdAccount()));
        List<ListOrderHistory> listOrderHistories = new ArrayList<>();
        listOrder.forEach(order -> {
            ListOrderHistory orders = mapper.map(order, ListOrderHistory.class);
            List<ProductHistory> productHistories = new ArrayList<>();
            productOrderRepo.findAllById(Collections.singleton(order.getIdOrder()))
                    .forEach(p -> productHistories.add(mapper.map(p, ProductHistory.class)));
            orders.setProduct(productHistories);
            listOrderHistories.add(orders);
        });

        return listOrderHistories;
    }

    @Override
    public ListOrderHistory detailOrderHistory(OrderRq rq) {
        try {
            ListOrderHistory order = mapper.map(orderRepo.findById(rq.getIdOrder()), ListOrderHistory.class);
            List<ProductHistory> productHistories = new ArrayList<>();
            productOrderRepo.findAllById(Collections.singleton(orderRepo.findById(rq.getIdOrder()).get().getIdOrder()))
                    .forEach(p -> productHistories.add(mapper.map(p, ProductHistory.class)));
            order.setProduct(productHistories);
            return order;
        } catch (Exception e){
            return new ListOrderHistory();
        }
    }
}
