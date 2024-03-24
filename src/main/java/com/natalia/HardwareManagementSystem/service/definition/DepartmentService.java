package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department findById(int id);
    List<Department> findAll();
}
