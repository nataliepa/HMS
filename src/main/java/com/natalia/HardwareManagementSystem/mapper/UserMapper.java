package com.natalia.HardwareManagementSystem.mapper;

import com.natalia.HardwareManagementSystem.dto.ManageUserDto;
import com.natalia.HardwareManagementSystem.dto.UserDto;
import com.natalia.HardwareManagementSystem.entity.CompanyBranch;
import com.natalia.HardwareManagementSystem.entity.Role;
import com.natalia.HardwareManagementSystem.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<UserDto> UserToUserDto(List<User> users) {

        List<UserDto> userDtoList = new ArrayList<>();

        for(User user : users) {
            UserDto userDto = new UserDto();

            userDto.setId(user.getId());
            userDto.setLastName(user.getLastName());
            userDto.setFirstName(user.getFirstName());
            userDto.setUsername(user.getUsername());
            userDto.setRole(user.getRole());
            userDto.setCompanyBranch(user.getCompanyBranch());

            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    public static UserDto UserToUserDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        userDto.setUsername(user.getUsername());
        userDto.setRole(user.getRole());
        userDto.setCompanyBranch(user.getCompanyBranch());

        return userDto;
    }

    public static List<User> UserDtoToUser(List<UserDto> usersDto) {

        List<User> userList = new ArrayList<>();

        for(UserDto userDto : usersDto) {
            User user = new User();

            user.setId(userDto.getId());
            user.setLastName(userDto.getLastName());
            user.setFirstName(userDto.getFirstName());
            user.setUsername(userDto.getUsername());
            user.setRole(userDto.getRole());
            user.setCompanyBranch(user.getCompanyBranch());

            userList.add(user);
        }

        return userList;
    }

    public static User AddUserDtoToUser(ManageUserDto manageUserDto, Role role, CompanyBranch companyBranch) {

        User user = new User();

        user.setLastName(manageUserDto.getLastName());
        user.setFirstName(manageUserDto.getFirstName());
        user.setUsername(manageUserDto.getUsername());
        user.setPassword(manageUserDto.getPassword());
        user.setRole(role);
        user.setCompanyBranch(companyBranch);

        return user;
    }
}
