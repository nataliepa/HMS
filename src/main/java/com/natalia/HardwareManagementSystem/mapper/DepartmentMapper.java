package com.natalia.HardwareManagementSystem.mapper;

import com.natalia.HardwareManagementSystem.dto.Department.DepartmentDto;
import com.natalia.HardwareManagementSystem.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentMapper {
    public static List<DepartmentDto> departmentToDepartmentDto(List<Department> departments) {

        List<DepartmentDto> departmentDtoList = new ArrayList<>();

        for(Department department : departments) {
            DepartmentDto departmentDto = new DepartmentDto();

            departmentDto.setId(department.getId());
            departmentDto.setName(department.getName());
            departmentDto.setAbbreviation(department.getAbbreviation());

            departmentDtoList.add(departmentDto);
        }

        return departmentDtoList;
    }
}
