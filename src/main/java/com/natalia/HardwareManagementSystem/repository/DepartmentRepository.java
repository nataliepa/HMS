package com.natalia.HardwareManagementSystem.repository;

import com.natalia.HardwareManagementSystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findAllByOrderByName();
    List<Department> findAll();
    Department findDepartmentById(int id);
}
