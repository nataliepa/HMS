package com.natalia.HardwareManagementSystem.controller;

import com.natalia.HardwareManagementSystem.dto.ManageUserDto;
import com.natalia.HardwareManagementSystem.dto.UserDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Role;
import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.mapper.UserMapper;
import com.natalia.HardwareManagementSystem.service.definition.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            model.addAttribute("addUserDto", new ManageUserDto());
            model.addAttribute("rolesList", rolesList);
            model.addAttribute("companyBranchList", companyBranchList);
            model.addAttribute("manageUserDto", new ManageUserDto());

            return "manageUsers";
        }

        return "error";
    }

    @PostMapping(value = {"/addUser"})
    public String addUser(Model model, @ModelAttribute("manageUserDto") ManageUserDto manageUserDto) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"

            Role newUserRole = userRoleService.findByName(manageUserDto.getRole());
            CompanyBranch companyBranch = companyBranchService.findByName(manageUserDto.getCompanyBranch());
            User newUser = UserMapper.AddUserDtoToUser(manageUserDto, newUserRole, companyBranch);

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

    @PostMapping(value = {"/updateUser"})
    public String updateUser(Model model, @ModelAttribute("manageUserDto") ManageUserDto manageUserDto) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"

            Role UserRole = userRoleService.findByName(manageUserDto.getRole());
            CompanyBranch companyBranch = companyBranchService.findByName(manageUserDto.getCompanyBranch());
            User updatedUser = UserMapper.AddUserDtoToUser(manageUserDto, UserRole, companyBranch);

            User findUser = userService.findByUsername(updatedUser.getUsername());

            if(findUser != null) {
                userService.updateUser(findUser, updatedUser);
                model.addAttribute("updatedMessage", "");
            } else {
                model.addAttribute("updatedMessage", "User not found");
            }

            return "redirect:/users";
        }

        return "error";
    }

    @PostMapping(value = {"/deleteUser"})
    public String deleteUser(Model model, @ModelAttribute("manageUserDto") ManageUserDto manageUserDto) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();  // username χρηστη
        User user = userService.findByUsername(username);  // ευρεση του χρηστη
        String role = loggedInUser.getAuthorities().toString();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"

            User findUser = userService.findById(manageUserDto.getId());

            if(findUser != null) {
                userService.delete(manageUserDto.getId());
                model.addAttribute("deleteMessage", "");
            } else {
                model.addAttribute("deleteMessage", "User not found");
            }

            return "redirect:/users";
        }

        return "error";
    }
}
