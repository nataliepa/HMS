package com.natalia.HardwareManagementSystem.mapper;

import com.natalia.HardwareManagementSystem.dto.workstation.GetWorkstationDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.Get;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class WorkstationMapper {
    public static List<GetWorkstationDto> workstationToGetWorkstationDto(List<Workstation> workstations) {

        List<GetWorkstationDto> workstationDto = new ArrayList<>();

        for(Workstation workstation : workstations) {
            GetWorkstationDto getWorkstationDto = new GetWorkstationDto();
            getWorkstationDto.setWorkstationId(workstation.getId());
            getWorkstationDto.setWorkstationName(workstation.getName());
            getWorkstationDto.setDepartmentName(workstation.getDepartment().getName());
            getWorkstationDto.setEmployeeLastName(workstation.getEmployee().getLastName());
            getWorkstationDto.setEmployeeFirstName(workstation.getEmployee().getFirstName());
            workstationDto.add(getWorkstationDto);
        }

        return workstationDto;
    }
}
