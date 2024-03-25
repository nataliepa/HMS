package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.dto.workstation.AddWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.WorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.UpdateWorkstationDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;
import com.natalia.HardwareManagementSystem.mapper.WorkstationMapper;
import com.natalia.HardwareManagementSystem.repository.WorkstationRepository;
import com.natalia.HardwareManagementSystem.service.definition.WorkstationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class WorkstationServiceImpl implements WorkstationService {

    @Autowired
    WorkstationRepository workstationRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<WorkstationDto> findAll(int companyBranchId, int departmentId) {

        List<Workstation> workstationList = workstationRepository
                .findAllByCompanyBranch_IdAndDepartment_IdOrderByName(companyBranchId, departmentId);

        List<WorkstationDto> workstationDtoList = WorkstationMapper.workstationToGetWorkstationDto(workstationList);

        return workstationDtoList;
    }

    @Override
    public WorkstationDto findById(int id) {
        return WorkstationMapper.workstationToGetWorkstationDto(workstationRepository.findWorkstationById(id));
    }

    @Override
    public Workstation findWorkstationById(int id) {
        return workstationRepository.findWorkstationById(id);
    }

    @Override
    public List<WorkstationDto> addWorkstation(int companyBranchId, int DepartmentId, AddWorkstationDto addWorkstationDto) {
        return null;
    }

    @Override
    public WorkstationDto updateWorkstation(UpdateWorkstationDto updateWorkstationDto) {
        return null;
    }

    @Override
    public List<WorkstationDto> DeleteWorkstation(int id) {
        return null;
    }
}
