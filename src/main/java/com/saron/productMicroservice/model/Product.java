package com.saron.productMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;

    public Product(long l, String long_sleeves, int i, String shirts) {

    }
}
