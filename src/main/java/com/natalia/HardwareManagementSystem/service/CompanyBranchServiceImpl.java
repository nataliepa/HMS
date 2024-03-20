package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.repository.CompanyBranchRepository;
import com.natalia.HardwareManagementSystem.service.definition.CompanyBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyBranchServiceImpl implements CompanyBranchService {

    @Autowired
    private CompanyBranchRepository companyBranchRepository;

    public CompanyBranchServiceImpl(CompanyBranchRepository companyBranchRepository) {
        this.companyBranchRepository = companyBranchRepository;
    }
    @Override
    public CompanyBranch findById(int id) {
        return companyBranchRepository.getById(id);
    }
}
