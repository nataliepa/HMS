package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Department;

import java.util.List;
import java.util.Optional;

public interface CompanyBranchService {
    CompanyBranchDto findById(int id);
    List<CompanyBranch> findAll();
}
