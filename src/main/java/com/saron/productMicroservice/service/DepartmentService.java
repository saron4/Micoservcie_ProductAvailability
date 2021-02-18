package com.saron.productMicroservice.service;

import com.saron.productMicroservice.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> searchDepartment(String key);
}
