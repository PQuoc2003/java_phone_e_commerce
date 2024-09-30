package com.example.phonecommerce.api;

import com.example.phonecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ImageAPI {


    private final ProductService productService;

    @Autowired
    public ImageAPI(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/api/image/{picture}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody Resource getImage(@PathVariable String picture) {
        return new ClassPathResource("static/" +  picture );
    }
}
