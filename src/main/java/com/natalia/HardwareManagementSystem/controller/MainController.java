package com.natalia.HardwareManagementSystem.controller;


import com.natalia.HardwareManagementSystem.dto.workstation.GetWorkstationDto;
import com.natalia.HardwareManagementSystem.dto.workstation.filter.PaginationFilter;
import com.natalia.HardwareManagementSystem.dto.workstation.filter.WorkstationFilterDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.repository.WorkstationRepository;
import com.natalia.HardwareManagementSystem.service.definition.UserRoleService;
import com.natalia.HardwareManagementSystem.service.definition.UserService;
import com.natalia.HardwareManagementSystem.service.definition.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final WorkstationService workstationService;

    public MainController(UserService userService, UserRoleService userRoleService, WorkstationService workstationService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.workstationService = workstationService;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/index")
    public String index(Model model/*, @ModelAttribute("getWorkstationDto") WorkstationFilterDto getWorkstationDto*/) {
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

        }
        else if (role.equals("[LocalAdmin]")) {
            workstationFilterDto.setCompanyBranchId(companyBranch.getId());
        }

        List<GetWorkstationDto> workstations = workstationService.getWorkstations(workstationFilterDto);
        int workstationsNum = workstations.size();



        model.addAttribute("user", user);
        model.addAttribute("userCount", userCount);
        model.addAttribute("workstations", workstations);
        model.addAttribute("workstationFilterDto", workstationFilterDto);
        model.addAttribute("workstationsNum", workstationsNum);

        return "index";
    }

    @GetMapping("/error")
    public String error() {

        return "error";
    }



    @GetMapping("/")
    public String any() {
        return "redirect:/index";
    }
}
