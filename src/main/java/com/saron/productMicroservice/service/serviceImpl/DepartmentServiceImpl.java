package com.saron.productMicroservice.service.serviceImpl;

import com.saron.productMicroservice.model.Department;
import com.saron.productMicroservice.repository.DepartmentRepository;
import com.saron.productMicroservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public List<Department> searchDepartments(String key) {
        return departmentRepository.finAllByDepartmentName(key);
    }
}
