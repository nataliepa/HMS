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
            companyBranchDto.setAddress(companyBranch.getAddress());
            companyBranchDto.setNumber(companyBranch.getNumber());
            companyBranchDto.setCity(companyBranch.getCity());
            companyBranchDto.setPostal_code(companyBranch.getPostal_code());

            companyBranchDtoList.add(companyBranchDto);
        }

        return companyBranchDtoList;
    }

    public static CompanyBranchDto companyBranchToCompanyBranchDto(CompanyBranch companyBranch) {

        CompanyBranchDto companyBranchDto = new CompanyBranchDto();

        companyBranchDto.setId(companyBranch.getId());
        companyBranchDto.setName(companyBranch.getName());
        companyBranchDto.setAddress(companyBranch.getAddress());
        companyBranchDto.setNumber(companyBranch.getNumber());
        companyBranchDto.setCity(companyBranch.getCity());
        companyBranchDto.setPostal_code(companyBranch.getPostal_code());


        return companyBranchDto;
    }

    public static CompanyBranch companyBranchDtoToCompanyBranch(CompanyBranchDto companyBranchDto) {

        CompanyBranch companyBranch = new CompanyBranch();

        companyBranch.setId(companyBranchDto.getId());
        companyBranch.setName(companyBranchDto.getName());
        companyBranch.setAddress(companyBranchDto.getAddress());
        companyBranch.setNumber(companyBranchDto.getNumber());
        companyBranch.setCity(companyBranchDto.getCity());
        companyBranch.setPostal_code(companyBranchDto.getPostal_code());


        return companyBranch;
    }
}
