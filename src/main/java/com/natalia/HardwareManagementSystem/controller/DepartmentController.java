package com.natalia.HardwareManagementSystem.controller;

import com.natalia.HardwareManagementSystem.dto.Department.DepartmentDto;
import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.dto.workstation.filter.PaginationFilter;
import com.natalia.HardwareManagementSystem.dto.workstation.filter.WorkstationFilterDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Department;
import com.natalia.HardwareManagementSystem.entity.User;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;
    private final CompanyBranchService companyBranchService;
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    public DepartmentController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService, CompanyBranchService companyBranchService, DepartmentService departmentService, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
        this.companyBranchService = companyBranchService;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/departments"})
    public String index(Model model, @RequestParam(required = false, name = "branchId") String branchId) {
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

        List<Department> departmentList = departmentService.findAll();
        List<DepartmentDto> departmentDtoList = DepartmentMapper.departmentToDepartmentDto(departmentList);

        model.addAttribute("departmentDtoList", departmentDtoList);
        model.addAttribute("user", user);
        model.addAttribute("branchId", branchId);
        model.addAttribute("companyBranchDto", companyBranchDto);

        return "departments";
    }

}
