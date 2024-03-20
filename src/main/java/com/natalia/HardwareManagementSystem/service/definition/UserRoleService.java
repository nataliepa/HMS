package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.entity.Role;
import java.util.List;

public interface UserRoleService {

    Role findById(int id);

    List<Role> findAll();

    Role findByName (String name);

}
