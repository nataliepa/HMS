package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.dto.workstation.AddWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.GetWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.UpdateWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.filter.WorkstationFilterDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;

import java.util.List;

public interface WorkstationService {
    List<GetWorkstationDto> getWorkstations();
    GetWorkstationDto getWorkstationById(int id);
    List<GetWorkstationDto> addWorkstation(int companyBranchId, int DepartmentId, AddWorkstationDto addWorkstationDto);
    GetWorkstationDto updateWorkstation(UpdateWorkstationDto updateWorkstationDto);
    List<GetWorkstationDto> DeleteWorkstation(int id);
}
