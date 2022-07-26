package com.mht.redisdemo.service;

import com.mht.redisdemo.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CacheEvictService {

    @Autowired
    private ProductService productService;


    @Autowired
    private CacheManager cacheManager;

    public void addProduct(Product product){
        System.out.println("save to product evict service");
        productService.getProducts().add(product);
        cacheManager.getCache("product").clear();
    }
}
