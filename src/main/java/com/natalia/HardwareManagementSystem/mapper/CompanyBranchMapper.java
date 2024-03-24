package com.natalia.HardwareManagementSystem.mapper;

import com.natalia.HardwareManagementSystem.dto.Department.DepartmentDto;
import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class CompanyBranchMapper {
    public static List<CompanyBranchDto> companyBranchToCompanyBranchDto(List<CompanyBranch> companyBranches) {

        List<CompanyBranchDto> companyBranchDtoList = new ArrayList<>();

        for(CompanyBranch companyBranch : companyBranches) {
            CompanyBranchDto companyBranchDto = new CompanyBranchDto();

            companyBranchDto.setId(companyBranch.getId());
            companyBranchDto.setName(companyBranch.getName());
            companyBranchDto.setAddress(companyBranchDto.getAddress());
            companyBranchDto.setNumber(companyBranchDto.getNumber());
            companyBranchDto.setCity(companyBranchDto.getCity());
            companyBranchDto.setPostal_code(companyBranchDto.getPostal_code());

            companyBranchDtoList.add(companyBranchDto);
        }

        return companyBranchDtoList;
    }
}
