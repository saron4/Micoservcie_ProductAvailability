package com.saron.productMicroservice.repository;

import com.saron.productMicroservice.model.Department;
import com.saron.productMicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByProductNameorProductId(String name, Long productId);
    List<Product> findAllByDepartmentName(Department department);

}
