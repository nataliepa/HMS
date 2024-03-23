package com.natalia.HardwareManagementSystem.dto.workstation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddWorkstationDto {
    private String workstationName;
    private String departmentName;
    private String employeeLastName;
    private String employeeFirstName;
}
