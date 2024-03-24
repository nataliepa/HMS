package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.entity.Department;
import com.natalia.HardwareManagementSystem.repository.CompanyBranchRepository;
import com.natalia.HardwareManagementSystem.repository.DepartmentRepository;
import com.natalia.HardwareManagementSystem.service.definition.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department findById(int id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAllByOrderByName();
    }
}
