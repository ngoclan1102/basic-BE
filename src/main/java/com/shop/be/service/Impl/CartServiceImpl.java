package com.shop.be.service.Impl;

import com.shop.be.Constant.Constant;
import com.shop.be.rq.ProductRq;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.entity.Cart;
import com.shop.be.repository.CartRepo;
import com.shop.be.repository.ProductRepo;
import com.shop.be.rp.ListProductOfCartRp;
import com.shop.be.rq.ListCartRq;
import com.shop.be.service.ICartService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductRepo productRepo;

    private final ModelMapper mapper = new ModelMapper();

    private List<Long> getIds(String []ids){
        List<Long> idList = new ArrayList<>();
        for (String id : ids) {
            idList.add(Long.parseLong(id));
        }

        return idList;
    }

    @Override
    public List<ListProductOfCartRp> listProduct(ListCartRq rq) {
        String []idProducts = cartRepo.findById(rq.getIdAccount()).get().getIdProduct().split(",");
        List<Long> ids = getIds(idProducts);

        List<ListProductOfCartRp> productList = new ArrayList<>();
        productRepo.findAll().forEach(p -> {
            if (ids.contains(p.getIdProduct())) {
                productList.add(mapper.map(p, ListProductOfCartRp.class));
            }
        });

        return productList;
    }

    @Override
    public String addToCart(ProductRq rq) {
        try {
            Cart cart = cartRepo.findCartByIdAccount(rq.getIdAccount());
            cart.setIdAccount(rq.getIdAccount());
            cart.setIdProduct(cart.getIdProduct() + rq.getIdProduct().toString() + ",");
            cartRepo.save(cart);
        }catch (Exception e) {
            System.out.printf("Exception: " + e);
            return Constant.Cart.addCartFail;
        }

        return Constant.Success;
    }

    @Override
    public String deleteProductOfCart(ProductRq rq) {
        try {
            String []idProducts = cartRepo.findCartByIdAccount(rq.getIdAccount()).getIdProduct().split(",");
            if (getIds(idProducts).contains(rq.getIdProduct())){
                Cart cart = cartRepo.findCartByIdAccount(rq.getIdAccount());
                String id = rq.getIdProduct() + ",";
                cart.setIdProduct(cart.getIdProduct().split(id).toString());
                cartRepo.save(cart);
            }
        }catch (Exception e){
            System.out.printf("Exception: " + e);
            return Constant.Cart.deleteCartFail;
        }

        return Constant.Success;
    }
}
