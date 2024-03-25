package com.natalia.HardwareManagementSystem.dto;

import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddUserDto {
    private int id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private String role;
    private String companyBranch;
}
