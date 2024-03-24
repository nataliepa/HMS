package com.natalia.HardwareManagementSystem.dto.companyBranch;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyBranchDto {
    private Integer id;
    private String city;
    private String postal_code;
    private String address;
    private String number;
    private String name;
}
