package com.example.TraningSpring.Controller;

import com.example.TraningSpring.models.Products;
import com.example.TraningSpring.servise.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor// инициализирует все обязяатлеьные поля
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title" , required = false) String title, Model model) {
        model.addAttribute("products", productService.getProductList(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductId(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(Products product) {
        productService.addProducts(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProducts(id);
        return "redirect:/";
    }
}
