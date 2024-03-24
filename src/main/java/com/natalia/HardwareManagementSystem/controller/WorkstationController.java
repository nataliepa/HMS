package com.natalia.HardwareManagementSystem.controller;

import com.natalia.HardwareManagementSystem.dto.Department.DepartmentDto;
import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.dto.workstation.WorkstationDto;
import com.natalia.HardwareManagementSystem.entity.Department;
import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.entity.Workstation;
import com.natalia.HardwareManagementSystem.mapper.CompanyBranchMapper;
import com.natalia.HardwareManagementSystem.mapper.DepartmentMapper;
import com.natalia.HardwareManagementSystem.service.definition.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WorkstationController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;
    private final CompanyBranchService companyBranchService;
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    public WorkstationController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService, CompanyBranchService companyBranchService, DepartmentService departmentService, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
        this.companyBranchService = companyBranchService;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/workstations"})
    public String index(Model model, @RequestParam(required = false, name = "branchId") String branchId,
                        @RequestParam(name = "departmentId") String departmentId) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        CompanyBranchDto companyBranchDto = new CompanyBranchDto();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"
            companyBranchDto = companyBranchService.findById(Integer.parseInt(branchId));
        }
        else if (role.equals("[LocalAdmin]")) {
            companyBranchDto = CompanyBranchMapper.companyBranchToCompanyBranchDto(user.getCompanyBranch());
        }

        List<WorkstationDto> workstationDtoList = workstationService.findAll(Integer.parseInt(branchId),
                                                                             Integer.parseInt(departmentId));
        DepartmentDto departmentDto = departmentService.findById(Integer.parseInt(departmentId));

        model.addAttribute("workstationDtoList", workstationDtoList);
        model.addAttribute("companyBranchDto", companyBranchDto);
        model.addAttribute("departmentDto", departmentDto);
        model.addAttribute("user", user);

        return "workstations";
    }
}
