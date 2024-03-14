package com.example.TraningSpring.repository;

import com.example.TraningSpring.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    List<Products> findByTitle (String title);
}
