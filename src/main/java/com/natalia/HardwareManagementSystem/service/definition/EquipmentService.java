package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.dto.equipment.CompanyPhoneDto;
import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.entity.equipment.Computer;

import java.util.List;

public interface EquipmentService {
    List<ComputerDto> findComputersByWorkstationId(int id);
    List<MonitorDto> findMonitorsByWorkstationId(int id);
    List<CompanyPhoneDto> findCompanyPhonesByWorkstationId(int id);
}
