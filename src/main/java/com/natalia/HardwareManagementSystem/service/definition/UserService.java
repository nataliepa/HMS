package com.natalia.HardwareManagementSystem.service.definition;


import com.natalia.HardwareManagementSystem.dto.UserProfileDto;
import com.natalia.HardwareManagementSystem.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);


    User findById(int id);

    List<User> findAll();

    User findByUsername(String username);


    void editProfile(User user, UserProfileDto userProfileDto);

    void editPassword(int id, String newPassword);



    void changepass(int id, User user);


    void disable(User user);

    void enable( User user);




}
