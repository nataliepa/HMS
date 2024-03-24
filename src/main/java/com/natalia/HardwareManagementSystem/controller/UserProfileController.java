package com.natalia.HardwareManagementSystem.controller;

import com.natalia.HardwareManagementSystem.dto.Department.DepartmentDto;
import com.natalia.HardwareManagementSystem.dto.UserPasswordDto;
import com.natalia.HardwareManagementSystem.dto.UserProfileDto;
import com.natalia.HardwareManagementSystem.dto.companyBranch.CompanyBranchDto;
import com.natalia.HardwareManagementSystem.entity.Department;
import com.natalia.HardwareManagementSystem.entity.Role;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserProfileController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;
    private final CompanyBranchService companyBranchService;
    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    public UserProfileController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService, CompanyBranchService companyBranchService, DepartmentService departmentService, ModelMapper modelMapper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
        this.companyBranchService = companyBranchService;
        this.departmentService = departmentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = {"/profile"})
    public String getProfile(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        UserProfileDto userProfileDto = new UserProfileDto(user.getLastName(), user.getFirstName());

        model.addAttribute("userProfileDto", userProfileDto);
        model.addAttribute("userPasswordDto", new UserPasswordDto());
        model.addAttribute("user", user);

        return "profile";
    }

    @PostMapping(value = {"/updateProfile"})
    public String updateProfile(Model model, @ModelAttribute("userProfileDto") UserProfileDto userProfileDto) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        userService.editProfile(user, userProfileDto);

        return "redirect:/profile";
    }

    @PostMapping(value = {"/updatePassword"})
    public String updatePassword(Model model, @ModelAttribute("userPasswordDto") UserPasswordDto userPasswordDto) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        userService.editPassword(user.getId(), userPasswordDto.getInputPassword());

        return "redirect:/profile";
    }
}
