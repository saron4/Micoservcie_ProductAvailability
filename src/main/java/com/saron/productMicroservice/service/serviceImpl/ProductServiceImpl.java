package com.saron.productMicroservice.service.serviceImpl;

import com.saron.productMicroservice.model.Product;
import com.saron.productMicroservice.service.ProductService;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Override
    public Page<Product> getProducts(int pageNo, int pageSize) {
        return null;
    }

    @Override
    public Product getProductById(Long productId) {
        return null;
    }

    @Override
    public List<Product> searchProducts(String key) {
        return null;
    }

    @Override
    public List<Product> getProductList() {
        return null;
    }
}
