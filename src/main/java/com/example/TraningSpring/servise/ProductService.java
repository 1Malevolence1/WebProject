package com.example.TraningSpring.servise;


import com.example.TraningSpring.models.Image;
import com.example.TraningSpring.models.Products;
import com.example.TraningSpring.repository.ProductRepository;
import jakarta.mail.Multipart;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.font.MultipleMaster;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public void addProducts(Products products, List<MultipartFile> images) throws IOException {
        log.info("save product {}", products);
        for (int picture = 0; picture < images.size(); picture++) {
            if(picture == 0){
                Image image = toImageEnity(images.get(picture));
                products.addImageToProduct(image);
            }
            else {
                products.addImageToProduct(toImageEnity(images.get(picture)));
            }
        }
    }

    private Image toImageEnity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
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
