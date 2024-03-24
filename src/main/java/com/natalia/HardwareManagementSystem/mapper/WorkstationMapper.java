package com.natalia.HardwareManagementSystem.mapper;

import com.natalia.HardwareManagementSystem.dto.workstation.WorkstationDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;

import java.util.ArrayList;
import java.util.List;

public class WorkstationMapper {
    public static List<WorkstationDto> workstationToGetWorkstationDto(List<Workstation> workstations) {

        List<WorkstationDto> workstationDto = new ArrayList<>();

        for(Workstation workstation : workstations) {
            WorkstationDto getWorkstationDto = new WorkstationDto();
            getWorkstationDto.setWorkstationId(workstation.getId());
            getWorkstationDto.setWorkstationName(workstation.getName());
            getWorkstationDto.setDepartmentName(workstation.getDepartment().getName());
            getWorkstationDto.setEmployeeLastName(workstation.getEmployee().getLastName());
            getWorkstationDto.setEmployeeFirstName(workstation.getEmployee().getFirstName());
            getWorkstationDto.setEmployeeEmail(workstation.getEmployee().getEmail());
            getWorkstationDto.setEmployeePhoneNumber(workstation.getEmployee().getPhoneNumber());
            workstationDto.add(getWorkstationDto);
        }

        return workstationDto;
    }

    public static WorkstationDto workstationToGetWorkstationDto(Workstation workstation) {


        WorkstationDto getWorkstationDto = new WorkstationDto();
        getWorkstationDto.setWorkstationId(workstation.getId());
        getWorkstationDto.setWorkstationName(workstation.getName());
        getWorkstationDto.setDepartmentName(workstation.getDepartment().getName());
        getWorkstationDto.setEmployeeLastName(workstation.getEmployee().getLastName());
        getWorkstationDto.setEmployeeFirstName(workstation.getEmployee().getFirstName());
        getWorkstationDto.setEmployeeEmail(workstation.getEmployee().getEmail());
        getWorkstationDto.setEmployeePhoneNumber(workstation.getEmployee().getPhoneNumber());

        return getWorkstationDto;
    }
}
