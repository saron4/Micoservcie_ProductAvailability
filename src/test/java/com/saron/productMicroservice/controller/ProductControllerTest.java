package com.saron.productMicroservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saron.productMicroservice.model.Product;
import com.saron.productMicroservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    ProductService productService;

    @Test
    void getProducts_ReturnsEmptyPage_IfThereAreNoProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        Page<Product> productPage = new PageImpl<>(productList);

        when(productService.getProducts(0,10)).thenReturn(productPage);
        mockMvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numberOfElements",is(0)))
                .andExpect(jsonPath("$.totalPages",is(1)))
                .andExpect(jsonPath("$.totalElements",is(0)))
                .andExpect(jsonPath("$.size",is(0)))
                .andExpect(jsonPath("$.number",is(0)))
                .andReturn();

        verify(productService, times(1)).getProducts(0,10);
        verifyNoMoreInteractions(productService);
    }

    @Test
    void getProducts_returnAPageWithData_IfThereAreProducts() throws Exception {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(11234L, "Long Sleeves", 100, "Shirts"));
        Page<Product> productPage = new PageImpl<>(productList);

        when(productService.getProducts(0,10)).thenReturn(productPage);
        mockMvc.perform(get("/products")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numberOfElements",is(1)))
                .andExpect(jsonPath("$.totalPages",is(1)))
                .andExpect(jsonPath("$.totalElements",is(1)))
                .andExpect(jsonPath("$.size",is(1)))
                .andExpect(jsonPath("$.number",is(0)))
                .andReturn();

        verify(productService, times(1)).getProducts(0,10);
        verifyNoMoreInteractions(productService);

    }

}

