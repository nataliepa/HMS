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
import com.natalia.HardwareManagementSystem.repository.EquipmentRepository;
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
    @Autowired
    EquipmentRepository<Computer> computerRepo;
    @Autowired
    EquipmentRepository<Monitor> monitorRepo;
    @Autowired
    EquipmentRepository<CompanyPhone> companyPhoneRepo;


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
    public ComputerDto addComputer(ComputerDto computerDto) {
        Computer computer = ComputerMapper.computerDtoToComputer(computerDto);

        return ComputerMapper.computerToComputerDto(computerRepo.save(computer));
    }

    @Override
    public MonitorDto addMonitor(MonitorDto monitorDto) {
        Monitor monitor = MonitorMapper.monitorDtoToMonitor(monitorDto);

        return MonitorMapper.monitorToMonitorDto(monitorRepo.save(monitor));
    }

    @Override
    public CompanyPhoneDto addCompanyPhone(CompanyPhoneDto companyPhoneDto) {
        CompanyPhone companyPhone = CompanyPhoneMapper.companyPhoneDtoToCompanyPhone(companyPhoneDto);

        return CompanyPhoneMapper.companyPhoneToCompanyPhoneDto(companyPhoneRepo.save(companyPhone));
    }

    @Override
    public ComputerDto updateComputer(ComputerDto computerDto) {
        Computer findComputer = computerRepository.findComputerById(computerDto.getId());

        if(findComputer != null) {
            Computer updatedComputer = ComputerMapper.computerDtoToComputer(computerDto);

            return ComputerMapper.computerToComputerDto(computerRepo.save(updatedComputer));

        }

        return null;
    }

    @Override
    public MonitorDto updateMonitor(MonitorDto monitorDto) {
        Monitor findMonitor = monitorRepository.findMonitorById(monitorDto.getId());

        if(findMonitor != null) {
            Monitor updatedMonitor = MonitorMapper.monitorDtoToMonitor(monitorDto);

            return MonitorMapper.monitorToMonitorDto(monitorRepo.save(updatedMonitor));

        }
        return null;
    }

    @Override
    public CompanyPhoneDto updateCompanyPhone(CompanyPhoneDto companyPhoneDto) {
        CompanyPhone findCompanyPhone = companyPhoneRepository.findCompanyPhoneById(companyPhoneDto.getId());

        if(findCompanyPhone != null) {
            CompanyPhone updatedCompanyPhone= CompanyPhoneMapper.companyPhoneDtoToCompanyPhone(companyPhoneDto);

            return CompanyPhoneMapper.companyPhoneToCompanyPhoneDto(companyPhoneRepo.save(updatedCompanyPhone));
        }

        return null;
    }

    @Override
    public String deleteComputer(int computerId) {
        Computer findComputer = computerRepository.findComputerById(computerId);

        if(findComputer != null) {
            computerRepo.delete(findComputer);
            return "";

        }
        return "Computer not found";
    }

    @Override
    public String deleteMonitor(int monitorId) {
        Monitor findMonitor = monitorRepository.findMonitorById(monitorId);

        if(findMonitor != null) {
            monitorRepo.delete(findMonitor);
            return "";

        }
        return "Monitor not found";
    }

    @Override
    public String deleteCompanyPhone(int companyPhoneId) {
        CompanyPhone findCompanyPhone = companyPhoneRepository.findCompanyPhoneById(companyPhoneId);

        if(findCompanyPhone != null) {
            companyPhoneRepo.delete(findCompanyPhone);
            return "";

        }
        return "Company Phone not found";
    }
}
