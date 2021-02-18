package com.saron.productMicroservice.controller;

import com.saron.productMicroservice.model.Product;
import com.saron.productMicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)

public class ProductController {

        @Autowired
        ProductService productService;

        @GetMapping
        public Page<Product> getProducts(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize){
            return productService.getProducts(pageNo, pageSize);
        }

        @GetMapping("/{productId}")
        public Product getProductById(@PathVariable Long productId){
            return productService.getProductById(productId);
        }

        @GetMapping("/search")
        public List<Product> searchProducts(@RequestParam String key){
            return productService.searchProducts(key);
        }

        @GetMapping("/list")
        public List<Product> getProductsList(){
            return productService.getProductList();
        }


}
