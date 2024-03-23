package com.natalia.HardwareManagementSystem.dto.workstation.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkstationFilterDto {
    private Integer CompanyBranchId = 0;
    private Integer DepartmentId = 0;
    private PaginationFilter paginationFilter;
}
