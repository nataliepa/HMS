package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.repository.CompanyBranchRepository;
import com.natalia.HardwareManagementSystem.service.definition.CompanyBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyBranchServiceImpl implements CompanyBranchService {

    @Autowired
    private CompanyBranchRepository companyBranchRepository;
    @Override
    public CompanyBranch findById(int id) {
        return companyBranchRepository.findCompanyBranchById(id);
    }

    @Override
    public List<CompanyBranch> findAll() {
        return companyBranchRepository.findAllByOrderByName();
    }
}
