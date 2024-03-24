package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.dto.Department.DepartmentDto;
import com.natalia.HardwareManagementSystem.entity.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto findById(int id);
    List<Department> findAll();
}
