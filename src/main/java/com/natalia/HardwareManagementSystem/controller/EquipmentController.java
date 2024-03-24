package com.natalia.HardwareManagementSystem.controller;

import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.dto.equipment.CompanyPhoneDto;
import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.mapper.CompanyBranchMapper;
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
public class EquipmentController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;
    private final CompanyBranchService companyBranchService;
    private final DepartmentService departmentService;
    private final EquipmentService equipmentService;
    private final ModelMapper modelMapper;

    public EquipmentController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService, CompanyBranchService companyBranchService, DepartmentService departmentService, EquipmentService equipmentService, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
        this.companyBranchService = companyBranchService;
        this.departmentService = departmentService;
        this.equipmentService = equipmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/equipment"})
    public String index(Model model, @RequestParam(required = false, name = "branchId") String branchId,
                                     @RequestParam(name = "departmentId") String departmentId,
                                     @RequestParam(name = "workstationId") String workstationId)
    {
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

        int id = Integer.parseInt(workstationId);

        List<ComputerDto> computerDtoList = equipmentService.findComputersByWorkstationId(id);
        List<MonitorDto> monitorDtoList = equipmentService.findMonitorsByWorkstationId(id);
        List<CompanyPhoneDto> companyPhoneDtoList = equipmentService.findCompanyPhonesByWorkstationId(id);

        //model.addAttribute("departmentDtoList", departmentDtoList);

        model.addAttribute("user", user);
        model.addAttribute("computerDtoList", computerDtoList);
        model.addAttribute("monitorDtoList", monitorDtoList);
        model.addAttribute("companyPhoneDtoList", companyPhoneDtoList);
        model.addAttribute("branchId", branchId);
        model.addAttribute("companyBranchDto", companyBranchDto);
        model.addAttribute("departmentId", departmentId);

        return "equipment";
    }
}
