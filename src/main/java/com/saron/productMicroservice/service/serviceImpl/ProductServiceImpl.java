package com.saron.productMicroservice.service.serviceImpl;

import com.saron.productMicroservice.model.Department;
import com.saron.productMicroservice.model.Product;
import com.saron.productMicroservice.repository.ProductRepository;
import com.saron.productMicroservice.service.DepartmentService;
import com.saron.productMicroservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DepartmentService departmentService;

    @Override
    public Page<Product> getProducts(int pageNo, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageNo,pageSize));
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> searchProducts(String key) {
        Long productId = 0L;
        try {
            productId = Long.parseLong(key);
        }
        catch (NumberFormatException ignored){}
        List<Department> departments = departmentService.searchDepartments(key);
        List<Product> products = new ArrayList<>(productRepository.findAllByProductNameorProductId(key,productId));
        for(Department department:departments){
            products.addAll(productRepository.findAllByDepartmentName(department));
        }

        return products.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();    }


}
