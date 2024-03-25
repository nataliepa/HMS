package com.natalia.HardwareManagementSystem.service.definition;

import com.natalia.HardwareManagementSystem.dto.equipment.CompanyPhoneDto;
import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.dto.workstation.WorkstationDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;
import com.natalia.HardwareManagementSystem.entity.equipment.Computer;
import com.natalia.HardwareManagementSystem.entity.equipment.Monitor;

import java.util.List;

public interface EquipmentService {
    List<ComputerDto> findComputersByWorkstationId(int id);
    List<MonitorDto> findMonitorsByWorkstationId(int id);
    List<CompanyPhoneDto> findCompanyPhonesByWorkstationId(int id);
    ComputerDto addComputer(ComputerDto computerDto, Workstation workstation);
    MonitorDto addMonitor(MonitorDto monitorDto, Workstation workstation);
    CompanyPhoneDto addCompanyPhone(CompanyPhoneDto companyPhoneDto, Workstation workstation);
    ComputerDto updateComputer(ComputerDto computerDto);
    MonitorDto updateMonitor(MonitorDto monitorDto);
    CompanyPhoneDto updateCompanyPhone(CompanyPhoneDto companyPhoneDto);
    String deleteComputer(int computerId);
    String deleteMonitor(int monitorId);
    String deleteCompanyPhone(int companyPhoneId);
}
