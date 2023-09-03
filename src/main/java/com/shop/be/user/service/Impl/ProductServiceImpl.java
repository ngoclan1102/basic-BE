package com.shop.be.user.service.Impl;

import com.shop.be.user.rq.ProductRq;
import com.shop.be.user.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.user.repository.ProductRepo;
import com.shop.be.user.rp.ProductDetail;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ProductDetail> listProduct() {
        List<ProductDetail> list = new ArrayList<>();
        productRepo.findAll().stream().filter(p -> p.getDeleteFlag() == 0).toList()
                .forEach(product -> list.add(mapper.map(product, ProductDetail.class)));
        return list;
    }

    @Override
    public ProductDetail detail(ProductRq rq) {
        return mapper.map(productRepo.findById(rq.getIdProduct()), ProductDetail.class);
    }
}
