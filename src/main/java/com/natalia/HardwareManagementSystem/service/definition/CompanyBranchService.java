package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Department;

import java.util.List;
import java.util.Optional;

public interface CompanyBranchService {
    CompanyBranch findById(int id);
    List<CompanyBranch> findAll();
}
