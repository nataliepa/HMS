package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.dto.equipment.CompanyPhoneDto;
import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.entity.equipment.CompanyPhone;
import com.natalia.HardwareManagementSystem.entity.equipment.Computer;
import com.natalia.HardwareManagementSystem.entity.equipment.Monitor;
import com.natalia.HardwareManagementSystem.mapper.equipment.CompanyPhoneMapper;
import com.natalia.HardwareManagementSystem.mapper.equipment.ComputerMapper;
import com.natalia.HardwareManagementSystem.mapper.equipment.MonitorMapper;
import com.natalia.HardwareManagementSystem.repository.equipment.CompanyPhoneRepository;
import com.natalia.HardwareManagementSystem.repository.equipment.ComputerRepository;
import com.natalia.HardwareManagementSystem.repository.equipment.MonitorRepository;
import com.natalia.HardwareManagementSystem.service.definition.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    ComputerRepository computerRepository;
    @Autowired
    MonitorRepository monitorRepository;
    @Autowired
    CompanyPhoneRepository companyPhoneRepository;

    @Override
    public List<ComputerDto> findComputersByWorkstationId(int id) {

        List<Computer> computerList = computerRepository.findAllByWorkstationIdOrderByManufacturer(id);

        List<ComputerDto> computerDtoList = ComputerMapper.computerToComputerDto(computerList);

        return computerDtoList;
    }

    @Override
    public List<MonitorDto> findMonitorsByWorkstationId(int id) {
        List<Monitor> monitorList = monitorRepository.findAllByWorkstationIdOrderByManufacturer(id);

        List<MonitorDto> monitorDtoList = MonitorMapper.monitorToMonitorDto(monitorList);

        return monitorDtoList;
    }

    @Override
    public List<CompanyPhoneDto> findCompanyPhonesByWorkstationId(int id) {
        List<CompanyPhone> companyPhoneList = companyPhoneRepository.findAllByWorkstationIdOrderByManufacturer(id);

        List<CompanyPhoneDto> companyPhoneDtoList = CompanyPhoneMapper.companyPhoneToCompanyPhoneDto(companyPhoneList);

        return companyPhoneDtoList;
    }
}
