package com.natalia.HardwareManagementSystem.repository.equipment;

import com.natalia.HardwareManagementSystem.entity.equipment.CompanyPhone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyPhoneRepository extends JpaRepository<CompanyPhone, Integer> {
    List<CompanyPhone> findAllByWorkstationIdOrderByManufacturer(int id);
}
