package com.natalia.HardwareManagementSystem.repository.equipment;

import com.natalia.HardwareManagementSystem.entity.equipment.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer> {
    List<Computer> findAllByWorkstationIdOrderByManufacturer(int id);
    Computer findComputerById(int id);
}
