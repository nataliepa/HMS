package com.natalia.HardwareManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManageUserDto {
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private String role;
    private String companyBranch;
}
