package com.example.phonecommerce.api;

import com.example.phonecommerce.models.Brand;
import com.example.phonecommerce.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandAPI {

    private final BrandService brandService;

    @Autowired
    public BrandAPI(BrandService brandService) {
        this.brandService = brandService;
    }


    @RequestMapping("/api/brands")
    public List<Brand> getAllBrand(){
        return brandService.getAllBrand();
    }


}
