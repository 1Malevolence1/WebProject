package com.example.TraningSpring.servise;


import com.example.TraningSpring.models.Products;
import com.example.TraningSpring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void addProducts(Products products) {
        log.info("save product {}", products);
        productRepository.save(products);
    }

    public List<Products> getProductList(String title) {
        log.info("Поисковой запрос на: {}", title);
        if (title != null) {
            return productRepository.findByTitle(title);
        } else {
            return productRepository.findAll();
        }
    }


    public void deleteProducts(Long id) {
       productRepository.deleteById(id);
    }

    public Products getProductId(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
