package com.shop.be.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.entity.Color;
import com.shop.be.repository.ColorRepo;
import com.shop.be.service.IColorService;

import java.util.List;

@Service
public class ColorServiceImpl implements IColorService {
    @Autowired
    private ColorRepo colorRepo;

    @Override
    public List<Color> getListColor() {
        return colorRepo.findAll();
    }
}
