package com.natalia.HardwareManagementSystem.controller;


import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.service.definition.UserRoleService;
import com.natalia.HardwareManagementSystem.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserService userService;
    private final UserRoleService userRoleService;

    public MainController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
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
         // πληθος ενεργων χρηστων
        long userCount = userService.findAll().stream().filter(u -> u.getEnable()==1).count();

        if (role.equals("[SuperAdmin]")) { // "SuperAdmin"

        }
        else if (role.equals("[LocalAdmin]")) {

        }


        model.addAttribute("user", user);
        model.addAttribute("userCount", userCount);

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
