package com.natalia.HardwareManagementSystem.dto.workstation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetWorkstationDto {
    private int workstationId;
    // a 4-digit number that increases according to the last workstation
    private String workstationName;
    private String departmentName;
    private String employeeLastName;
    private String employeeFirstName;
}
