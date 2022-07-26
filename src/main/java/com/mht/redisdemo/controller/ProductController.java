package com.mht.redisdemo.controller;

import com.mht.redisdemo.dto.Product;
import com.mht.redisdemo.service.CacheEvictService;
import com.mht.redisdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CacheEvictService cacheEvictService;

    @GetMapping("/product")
    public List<Product> getProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product){
        cacheEvictService.addProduct(product);
        return "success";
    }
}
