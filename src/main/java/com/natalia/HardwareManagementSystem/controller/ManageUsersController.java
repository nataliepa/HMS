package com.natalia.HardwareManagementSystem.controller;

import com.natalia.HardwareManagementSystem.dto.AddUserDto;
import com.natalia.HardwareManagementSystem.dto.UserDto;
import com.natalia.HardwareManagementSystem.dto.UserProfileDto;
import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Role;
import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.mapper.CompanyBranchMapper;
import com.natalia.HardwareManagementSystem.mapper.UserMapper;
import com.natalia.HardwareManagementSystem.service.definition.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManageUsersController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;
    private final CompanyBranchService companyBranchService;
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    public ManageUsersController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService, CompanyBranchService companyBranchService, DepartmentService departmentService, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
        this.companyBranchService = companyBranchService;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/users"})
    public String getUsers(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"
            List<UserDto> userDtoList = userService.findAllAndSort();
            List<Role> rolesList = userRoleService.findAll();
            List<CompanyBranch> companyBranchList = companyBranchService.findAll();

            model.addAttribute("userDtoList", userDtoList);
            model.addAttribute("user", user);
            model.addAttribute("addUserDto", new AddUserDto());
            model.addAttribute("rolesList", rolesList);
            model.addAttribute("companyBranchList", companyBranchList);

            return "manageUsers";
        }

        return "error";
    }

    @PostMapping(value = {"/addUser"})
    public String addUser(Model model, @ModelAttribute("addUserDto") AddUserDto addUserDto) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"

            Role newUserRole = userRoleService.findByName(addUserDto.getRole());
            CompanyBranch companyBranch = companyBranchService.findByName(addUserDto.getCompanyBranch());
            User newUser = UserMapper.AddUserDtoToUser(addUserDto, newUserRole, companyBranch);

            if(userService.findByUsername(newUser.getUsername()) == null) {
                userService.save(newUser);
                model.addAttribute("savedMessage", "");
            } else {
                model.addAttribute("savedMessage", "The user already exists");
            }

            return "redirect:/users";
        }

        return "error";
    }
}
