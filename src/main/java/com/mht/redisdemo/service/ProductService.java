package com.mht.redisdemo.service;

import com.mht.redisdemo.dto.Product;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    @Order(1)
    @EventListener(ApplicationReadyEvent.class)
    public void startEvent(){
        products.add( new Product("Samsung M53", "M53", "Cool smartphone"));
        products.add( new Product("Samsung M13", "M13", "budget smartphone"));
        products.add( new Product("LG Xperia", "xp", "smallest smartphone"));


    }

    @Cacheable(cacheNames = "product")
    public List<Product> getAllProduct(){
        System.out.println("get all product service");
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        products.add( new Product("Vivo M53", "M53", "Cool smartphone"));
        products.add( new Product("Oppo M13", "M13", "budget smartphone"));
        products.add( new Product("Lemon Xperia", "xp", "smallest smartphone"));
        return products;
    }

    /**
     * @CacheEvict not working in case of Redis, for SIMPLE cache it is working.
     * For redis created another method in CacheEvictService class, in which we manually clear the cache
     * @param product
     */
//    @CacheEvict(cacheNames = "product")
    public void addProduct(Product product){
        System.out.println("save to product");
        if(products == null) {
            products = new ArrayList<>();
        }
        if(product == null) {
            return;
        }
        System.out.println("save to product 2 ");
        products.add(product);
    }


}
