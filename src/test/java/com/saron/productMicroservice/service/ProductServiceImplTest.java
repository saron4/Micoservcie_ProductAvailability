package com.saron.productMicroservice.service;

import com.saron.productMicroservice.model.Product;
import com.saron.productMicroservice.repository.ProductRepository;
import com.saron.productMicroservice.service.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;

    @Mock
    ProductRepository productRepository;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getProducts_ReturnsEmptyPage_IfThereAreNoProducts() {
        List<Product> productList = new ArrayList<>();
        Page<Product> productPage = new PageImpl<>(productList);

        when(productRepository.findAll(PageRequest.of(0,10))).thenReturn(productPage);
        Page<Product> productPageReturned = productService.getProducts(0,10);
        assertEquals(0,productPageReturned.getNumberOfElements());
        assertEquals(0,productPageReturned.getTotalElements());
        assertEquals(1,productPageReturned.getTotalPages());
        assertEquals(0,productPageReturned.getSize());
        assertEquals(0,productPageReturned.getNumber());
    }

}
