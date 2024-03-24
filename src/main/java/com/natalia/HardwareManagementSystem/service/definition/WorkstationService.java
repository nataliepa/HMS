package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.dto.workstation.AddWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.WorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.UpdateWorkstationDto;

import java.util.List;

public interface WorkstationService {
    List<WorkstationDto> findAll(int companyBranchId, int departmentId);
    WorkstationDto findById(int id);
    List<WorkstationDto> addWorkstation(int companyBranchId, int DepartmentId, AddWorkstationDto addWorkstationDto);
    WorkstationDto updateWorkstation(UpdateWorkstationDto updateWorkstationDto);
    List<WorkstationDto> DeleteWorkstation(int id);
}
