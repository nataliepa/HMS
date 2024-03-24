package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.mapper.CompanyBranchMapper;
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
    public CompanyBranchDto findById(int id) {
        CompanyBranch companyBranch = companyBranchRepository.findCompanyBranchById(id);
        CompanyBranchDto companyBranchDto = CompanyBranchMapper.companyBranchToCompanyBranchDto(companyBranch);
        return companyBranchDto;
    }

    @Override
    public List<CompanyBranch> findAll() {
        return companyBranchRepository.findAllByOrderByName();
    }
}
