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

    public static ComputerDto computerToComputerDto(Computer computer) {

        ComputerDto computerDto = new ComputerDto();

        computerDto.setId(computer.getId());
        computerDto.setManufacturer(computer.getManufacturer());
        computerDto.setModel(computer.getModel());
        computerDto.setSerialNumber(computer.getSerialNumber());
        computerDto.setCpu(computer.getCpu());
        computerDto.setRam(computer.getRam());
        computerDto.setOperatingSystem(computer.getOperatingSystem());


        return computerDto;
    }

    public static Computer computerDtoToComputer(ComputerDto computerDto) {

        Computer computer = new Computer();

        computer.setId(computerDto.getId());
        computer.setManufacturer(computerDto.getManufacturer());
        computer.setModel(computerDto.getModel());
        computer.setSerialNumber(computerDto.getSerialNumber());
        computer.setCpu(computerDto.getCpu());
        computer.setRam(computerDto.getRam());
        computer.setOperatingSystem(computerDto.getOperatingSystem());


        return computer;
    }
}
