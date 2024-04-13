package com.natalia.HardwareManagementSystem.service;

import com.natalia.HardwareManagementSystem.dto.equipment.CompanyPhoneDto;
import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.entity.Workstation;
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

    @Override
    public ComputerDto addComputer(ComputerDto computerDto, Workstation workstation) {
        Computer computer = ComputerMapper.computerDtoToComputer(computerDto);
        computer.setWorkstation(workstation);

        return ComputerMapper.computerToComputerDto(computerRepository.save(computer));
    }

    @Override
    public MonitorDto addMonitor(MonitorDto monitorDto, Workstation workstation) {
        Monitor monitor = MonitorMapper.monitorDtoToMonitor(monitorDto);
        monitor.setWorkstation(workstation);

        return MonitorMapper.monitorToMonitorDto(monitorRepository.save(monitor));
    }

    @Override
    public CompanyPhoneDto addCompanyPhone(CompanyPhoneDto companyPhoneDto, Workstation workstation) {
        CompanyPhone companyPhone = CompanyPhoneMapper.companyPhoneDtoToCompanyPhone(companyPhoneDto);
        companyPhone.setWorkstation(workstation);

        return CompanyPhoneMapper.companyPhoneToCompanyPhoneDto(companyPhoneRepository.save(companyPhone));
    }

    @Override
    public ComputerDto updateComputer(ComputerDto computerDto, Workstation workstation) {
        Computer findComputer = computerRepository.findComputerById(computerDto.getId());

        if(findComputer != null) {
            Computer updatedComputer = ComputerMapper.computerDtoToComputer(computerDto);
            updatedComputer.setWorkstation(workstation);

            return ComputerMapper.computerToComputerDto(computerRepository.save(updatedComputer));

        }

        return null;
    }

    @Override
    public MonitorDto updateMonitor(MonitorDto monitorDto, Workstation workstation) {
        Monitor findMonitor = monitorRepository.findMonitorById(monitorDto.getId());

        if(findMonitor != null) {
            Monitor updatedMonitor = MonitorMapper.monitorDtoToMonitor(monitorDto);
            updatedMonitor.setWorkstation(workstation);

            return MonitorMapper.monitorToMonitorDto(monitorRepository.save(updatedMonitor));

        }
        return null;
    }

    @Override
    public CompanyPhoneDto updateCompanyPhone(CompanyPhoneDto companyPhoneDto, Workstation workstation) {
        CompanyPhone findCompanyPhone = companyPhoneRepository.findCompanyPhoneById(companyPhoneDto.getId());

        if(findCompanyPhone != null) {
            CompanyPhone updatedCompanyPhone= CompanyPhoneMapper.companyPhoneDtoToCompanyPhone(companyPhoneDto);
            updatedCompanyPhone.setWorkstation(workstation);

            return CompanyPhoneMapper.companyPhoneToCompanyPhoneDto(companyPhoneRepository.save(updatedCompanyPhone));
        }

        return null;
    }

    @Override
    public String deleteComputer(int computerId) {
        Computer findComputer = computerRepository.findComputerById(computerId);

        if(findComputer != null) {
            computerRepository.delete(findComputer);
            return "";

        }
        return "Computer not found";
    }

    @Override
    public String deleteMonitor(int monitorId) {
        Monitor findMonitor = monitorRepository.findMonitorById(monitorId);

        if(findMonitor != null) {
            monitorRepository.delete(findMonitor);
            return "";

        }
        return "Monitor not found";
    }

    @Override
    public String deleteCompanyPhone(int companyPhoneId) {
        CompanyPhone findCompanyPhone = companyPhoneRepository.findCompanyPhoneById(companyPhoneId);

        if(findCompanyPhone != null) {
            companyPhoneRepository.delete(findCompanyPhone);
            return "";

        }
        return "Company Phone not found";
    }
}
