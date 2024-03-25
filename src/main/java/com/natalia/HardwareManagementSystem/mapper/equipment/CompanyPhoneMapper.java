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

    public static CompanyPhoneDto companyPhoneToCompanyPhoneDto(CompanyPhone companyPhone) {

        CompanyPhoneDto companyPhoneDto = new CompanyPhoneDto();

        companyPhoneDto.setId(companyPhone.getId());
        companyPhoneDto.setManufacturer(companyPhone.getManufacturer());
        companyPhoneDto.setModel(companyPhone.getModel());
        companyPhoneDto.setSerialNumber(companyPhone.getSerialNumber());
        companyPhoneDto.setPhoneNumber(companyPhone.getPhoneNumber());

        return companyPhoneDto;
    }

    public static CompanyPhone companyPhoneDtoToCompanyPhone(CompanyPhoneDto companyPhoneDto) {

        CompanyPhone companyPhone = new CompanyPhone();

        companyPhone.setId(companyPhoneDto.getId());
        companyPhone.setManufacturer(companyPhoneDto.getManufacturer());
        companyPhone.setModel(companyPhoneDto.getModel());
        companyPhone.setSerialNumber(companyPhoneDto.getSerialNumber());
        companyPhone.setPhoneNumber(companyPhoneDto.getPhoneNumber());

        return companyPhone;
    }
}
