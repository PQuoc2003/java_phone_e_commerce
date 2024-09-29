package com.example.phonecommerce.api;

import com.example.phonecommerce.models.Colors;
import com.example.phonecommerce.service.ColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ColorsAPI {

    private final ColorsService colorsService;

    @Autowired
    public ColorsAPI(ColorsService colorsService) {
        this.colorsService = colorsService;
    }

    @RequestMapping("/api/colors")
    public List<Colors> getAllColor(){
        return colorsService.getAllColor();
    }


}
