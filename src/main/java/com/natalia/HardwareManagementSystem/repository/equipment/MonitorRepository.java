package com.natalia.HardwareManagementSystem.repository.equipment;

import com.natalia.HardwareManagementSystem.entity.equipment.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
    List<Monitor> findAllByWorkstationIdOrderByManufacturer(int id);
    Monitor findMonitorById(int id);
}
