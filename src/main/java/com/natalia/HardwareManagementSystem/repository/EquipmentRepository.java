package com.natalia.HardwareManagementSystem.repository;

import com.natalia.HardwareManagementSystem.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository<T extends Equipment> extends JpaRepository<T, Integer> {

}
