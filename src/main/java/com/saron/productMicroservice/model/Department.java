package com.saron.productMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "Department")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer deptId;

    @Column(name = "department_name")
    private String deptName;

}
