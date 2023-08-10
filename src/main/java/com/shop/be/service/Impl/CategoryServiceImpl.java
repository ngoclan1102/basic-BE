package com.shop.be.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.repository.CategoryRepo;
import com.shop.be.rp.ListCategoryRp;
import com.shop.be.service.ICategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
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
