package com.saron.productMicroservice.service;

import com.saron.productMicroservice.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {

    List<Department> searchDepartments(String key);
}
