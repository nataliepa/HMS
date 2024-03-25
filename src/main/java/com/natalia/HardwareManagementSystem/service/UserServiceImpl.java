package com.natalia.HardwareManagementSystem.service;


import com.natalia.HardwareManagementSystem.dto.UserDto;
import com.natalia.HardwareManagementSystem.dto.UserProfileDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Role;
import com.natalia.HardwareManagementSystem.entity.User;
import com.natalia.HardwareManagementSystem.mapper.CompanyBranchMapper;
import com.natalia.HardwareManagementSystem.mapper.UserMapper;
import com.natalia.HardwareManagementSystem.repository.RoleRepository;
import com.natalia.HardwareManagementSystem.repository.UserRepository;
import com.natalia.HardwareManagementSystem.service.definition.CompanyBranchService;
import com.natalia.HardwareManagementSystem.service.definition.UserRoleService;
import com.natalia.HardwareManagementSystem.service.definition.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private CompanyBranchService companyBranchService;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CompanyBranchService companyBranchService) {
        super();
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.companyBranchService = companyBranchService;
    }
   // ακροατης που δημιουργει την 1η μονο φορα χρηστη στην ΒΔ
    @EventListener(ApplicationReadyEvent.class)
    public User createAdmin() {
        if (userRepository.findByUsername("admin") == null) {

            User admin = new User("admin", "admin", "admin", "admin", passwordEncoder.encode("Admin!1234"), 1,
                    roleRepository.findByName("SuperAdmin"),
                    CompanyBranchMapper.companyBranchDtoToCompanyBranch(companyBranchService.findById(1)));
            return userRepository.save(admin);
        }

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User authenticatedUser = userRepository.findByUsername(username);
        //this.authenticatedUser = authenticatedUser;
        if (authenticatedUser == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(authenticatedUser.getUsername(), authenticatedUser.getPassword(), getAuthorities(authenticatedUser.getRole()));
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Role role) {

        return Arrays.asList(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public User save(User user) {

        String lastname = user.getLastName().trim();
        String firstname = user.getFirstName().trim();
        String username = user.getUsername().trim();
        String code = passwordEncoder.encode(user.getPassword());
        Role userRole = userRoleService.findById(user.getRole().getId());
        String comments = user.getComments();
        CompanyBranch companyBranch = CompanyBranchMapper.companyBranchDtoToCompanyBranch(companyBranchService.findById(user.getCompanyBranch().getId()));

        if (userRepository.findByUsername(username) == null) {

            User newUser = new User(comments, lastname, firstname, username, code, 1,
                    userRole, companyBranch);
            return userRepository.save(newUser);

        } else return null;

    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void editProfile(User user, UserProfileDto userProfileDto) {
        User found = userRepository.findById(user.getId());

        found.setFirstName(userProfileDto.getInputFirstName());
        found.setLastName(userProfileDto.getInputLastName());

        userRepository.save(found);
    }

    @Override
    public void editPassword(int id, String newPassword) {
        User found = userRepository.findById(id);

        if (!newPassword.isEmpty()){
            found.setPassword(passwordEncoder.encode(newPassword));
        }

        userRepository.save(found);
    }




    @Override
    public void changepass(int id, User user) {
        User found = userRepository.findById(id);
        found.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(found);
    }

    @Override
    public void disable(User user) {

        user.setEnable(0);
        userRepository.save(user);
    }

    @Override
    public void enable(User user) {
        user.setEnable(1);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> findAllAndSort() {

        List<User> userList = userRepository.findAllByOrderByLastName();

        return UserMapper.UserToUserDto(userList);
    }

    // μεθοδος που επιστρεφει τυχαια συμβολοσειρα
    public static String alphaNumericString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
