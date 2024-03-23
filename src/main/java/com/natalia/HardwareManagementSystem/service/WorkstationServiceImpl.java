package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.dto.workstation.AddWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.GetWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.UpdateWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.filter.WorkstationFilterDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;
import com.natalia.HardwareManagementSystem.mapper.WorkstationMapper;
import com.natalia.HardwareManagementSystem.repository.WorkstationRepository;
import com.natalia.HardwareManagementSystem.service.definition.WorkstationService;
import org.apache.commons.collections4.Get;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class WorkstationServiceImpl implements WorkstationService {

    @Autowired
    WorkstationRepository workstationRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<GetWorkstationDto> getWorkstations(WorkstationFilterDto workstationFilterDto) {

        List<GetWorkstationDto> workstationsDto = new ArrayList<>();
        List<Workstation> workstations = new ArrayList<>();
        int page = workstationFilterDto.getPaginationFilter().page;
        int itemsPerPage = workstationFilterDto.getPaginationFilter().getItemsPerPage();

        int companyBranchId = workstationFilterDto.getCompanyBranchId();
        int departmentId = workstationFilterDto.getDepartmentId();

        Pageable pageReq = PageRequest.of(page, itemsPerPage, Sort.by("name").ascending());

        if(companyBranchId != 0 && departmentId !=0) {
            workstations = workstationRepository.findAllByCompanyBranch_IdAndDepartment_Id(companyBranchId, departmentId, pageReq);
        } else if(companyBranchId != 0){
            workstations = workstationRepository.findAllByCompanyBranch_Id(companyBranchId, pageReq);
        } else {
            workstations = workstationRepository.findAll(pageReq).stream().toList();
        }

        //modelMapper.map(workstations, workstationsDto);
        workstationsDto = WorkstationMapper.workstationToGetWorkstationDto(workstations);

        return workstationsDto;
    }

    @Override
    public GetWorkstationDto getWorkstationById(int id) {
        return null;
    }

    @Override
    public List<GetWorkstationDto> addWorkstation(int companyBranchId, int DepartmentId, AddWorkstationDto addWorkstationDto) {
        return null;
    }

    @Override
    public GetWorkstationDto updateWorkstation(UpdateWorkstationDto updateWorkstationDto) {
        return null;
    }

    @Override
    public List<GetWorkstationDto> DeleteWorkstation(int id) {
        return null;
    }
}
