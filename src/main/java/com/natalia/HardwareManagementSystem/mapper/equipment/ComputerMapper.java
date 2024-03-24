package com.natalia.HardwareManagementSystem.mapper.equipment;

import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.equipment.Computer;

import java.util.ArrayList;
import java.util.List;

public class ComputerMapper {

    public static List<ComputerDto> computerToComputerDto(List<Computer> computers) {

        List<ComputerDto> computerDtoList = new ArrayList<>();

        for(Computer computer : computers) {
            ComputerDto computerDto = new ComputerDto();

            computerDto.setId(computer.getId());
            computerDto.setManufacturer(computer.getManufacturer());
            computerDto.setModel(computer.getModel());
            computerDto.setSerialNumber(computer.getSerialNumber());
            computerDto.setCpu(computer.getCpu());
            computerDto.setRam(computer.getRam());
            computerDto.setOperatingSystem(computer.getOperatingSystem());


            computerDtoList.add(computerDto);
        }

        return computerDtoList;
    }
}
