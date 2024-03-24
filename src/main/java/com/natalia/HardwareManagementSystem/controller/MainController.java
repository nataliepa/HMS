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

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;
    private final CompanyBranchService companyBranchService;
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    public MainController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService, CompanyBranchService companyBranchService, DepartmentService departmentService, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
        this.companyBranchService = companyBranchService;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/index")
    public String index(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();  // ρολος χρηστη
        CompanyBranch companyBranch = user.getCompanyBranch();
        WorkstationFilterDto workstationFilterDto = new WorkstationFilterDto();
        workstationFilterDto.setPaginationFilter(new PaginationFilter());

         // πληθος ενεργων χρηστων
        long userCount = userService.findAll().stream().filter(u -> u.getEnable()==1).count();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"
            // return branches
            List<CompanyBranch> companyBranchList = companyBranchService.findAll();
            List<CompanyBranchDto> companyBranchDtoList = CompanyBranchMapper.companyBranchToCompanyBranchDto(companyBranchList);

            model.addAttribute("companyBranchDtoList", companyBranchDtoList);
            model.addAttribute("userCount", userCount);
        }
        else if (role.equals("[LocalAdmin]")) {
            List<Department> departmentList = departmentService.findAll();
            List<DepartmentDto> departmentDtoList = DepartmentMapper.departmentToDepartmentDto(departmentList);

            model.addAttribute("departmentDtoList", departmentDtoList);
        }

        model.addAttribute("user", user);
        return "index";
    }



    @GetMapping("/")
    public String any() {
        return "redirect:/index";
    }
}
