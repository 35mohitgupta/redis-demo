package com.mht.redisdemo.service;

import com.mht.redisdemo.dto.Product;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;


    @Cacheable(cacheNames = "product")
    public List<Product> getAllProduct(){
        System.out.println("get all product service");
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        products.add( new Product("Samsung M53", "M53", "Cool smartphone"));
        products.add( new Product("Samsung M13", "M13", "budget smartphone"));
        products.add( new Product("LG Xperia", "xp", "smallest smartphone"));
        products = new ArrayList<>();
        return products;
    }

    @CacheEvict(cacheNames = "product")
    public void addProduct(Product product){
        System.out.println("save to product");
        if(products == null)
            products = new ArrayList<>();
        if(product == null)
            return;
        products.add(product);
    }


}
