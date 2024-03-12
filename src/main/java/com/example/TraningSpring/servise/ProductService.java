package com.example.TraningSpring.servise;


import com.example.TraningSpring.models.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
        private List<Products> products = new ArrayList<>();
        private long ID = 0;

         {
            products.add(new Products(ID++,"Ноубтук", "Копмпактный", 40_000, "Пятигоск", "acer"));
            products.add(new Products(ID++,"play staystation 5", "новый", 80_000, "Пятигоск", "Sony"));
         }

        public void addProducts(Products products){
             products.setId(ID++);
            if(this.products == null){
                this.products = new ArrayList<>();
            }
            this.products.add(products);
        }

        public List<Products> getProductList(){
            return products;
        }


        public void deleteProducts(Long id){
             products.removeIf(products -> products.getId().equals(id));
        }

    public Products getProductId(Long id) {
        for (Products product : products) {
            if (product.getId().equals(id)) return product;
        }
        return null;
    }
}
