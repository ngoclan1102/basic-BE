package com.shop.be.user.service.Impl;

import com.shop.be.user.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.user.repository.CategoryRepo;
import com.shop.be.user.rp.ListCategoryRp;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ListCategoryRp> getListCategory() {
        List<ListCategoryRp> listCategoryRps = new ArrayList<>();
        categoryRepo.findAll().forEach(cate -> listCategoryRps.add(mapper.map(cate, ListCategoryRp.class)));
        return listCategoryRps;
    }
}
