package com.saron.productMicroservice.repository;

import com.saron.productMicroservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> finAllByDepartmentName(String deptName);
}
