package com.natalia.HardwareManagementSystem.mapper.equipment;

import com.natalia.HardwareManagementSystem.dto.equipment.CompanyPhoneDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.entity.equipment.CompanyPhone;
import com.natalia.HardwareManagementSystem.entity.equipment.Monitor;

import java.util.ArrayList;
import java.util.List;

public class CompanyPhoneMapper {

    public static List<CompanyPhoneDto> companyPhoneToCompanyPhoneDto(List<CompanyPhone> companyPhones) {

        List<CompanyPhoneDto> companyPhoneDtoList = new ArrayList<>();

        for(CompanyPhone companyPhone : companyPhones) {
            CompanyPhoneDto companyPhoneDto = new CompanyPhoneDto();

            companyPhoneDto.setId(companyPhone.getId());
            companyPhoneDto.setManufacturer(companyPhone.getManufacturer());
            companyPhoneDto.setModel(companyPhone.getModel());
            companyPhoneDto.setSerialNumber(companyPhone.getSerialNumber());
            companyPhoneDto.setPhoneNumber(companyPhone.getPhoneNumber());

            companyPhoneDtoList.add(companyPhoneDto);
        }

        return companyPhoneDtoList;
    }
}
