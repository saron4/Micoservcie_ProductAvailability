package com.saron.productMicroservice.service;

import com.saron.productMicroservice.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {

   Page<Product> getProducts(int pageNo, int pageSize);
   Product getProductById(Long productId);
   List<Product> searchProducts(String key);
   List<Product> getProductList();




}
