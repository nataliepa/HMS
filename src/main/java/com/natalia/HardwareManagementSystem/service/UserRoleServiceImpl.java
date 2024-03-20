package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.entity.Role;
import com.natalia.HardwareManagementSystem.repository.RoleRepository;
import com.natalia.HardwareManagementSystem.service.definition.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private RoleRepository roleRepository;

    public UserRoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
