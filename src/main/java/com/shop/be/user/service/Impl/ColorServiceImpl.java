package com.shop.be.user.service.Impl;

import com.shop.be.user.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.be.entity.Color;
import com.shop.be.user.repository.ColorRepo;

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
