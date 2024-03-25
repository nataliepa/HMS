package com.natalia.HardwareManagementSystem.mapper.equipment;

import com.natalia.HardwareManagementSystem.dto.equipment.ComputerDto;
import com.natalia.HardwareManagementSystem.dto.equipment.MonitorDto;
import com.natalia.HardwareManagementSystem.entity.equipment.Computer;
import com.natalia.HardwareManagementSystem.entity.equipment.Monitor;

import java.util.ArrayList;
import java.util.List;

public class MonitorMapper {
    public static List<MonitorDto> monitorToMonitorDto(List<Monitor> monitors) {

        List<MonitorDto> monitorDtoList = new ArrayList<>();

        for(Monitor monitor : monitors) {
            MonitorDto monitorDto = new MonitorDto();

            monitorDto.setId(monitor.getId());
            monitorDto.setManufacturer(monitor.getManufacturer());
            monitorDto.setModel(monitor.getModel());
            monitorDto.setSerialNumber(monitor.getSerialNumber());
            monitorDto.setScreenSize(monitor.getScreenSize());
            monitorDto.setScreenResolution(monitor.getScreenResolution());

            monitorDtoList.add(monitorDto);
        }

        return monitorDtoList;
    }

    public static MonitorDto monitorToMonitorDto(Monitor monitor) {


        MonitorDto monitorDto = new MonitorDto();

        monitorDto.setId(monitor.getId());
        monitorDto.setManufacturer(monitor.getManufacturer());
        monitorDto.setModel(monitor.getModel());
        monitorDto.setSerialNumber(monitor.getSerialNumber());
        monitorDto.setScreenSize(monitor.getScreenSize());
        monitorDto.setScreenResolution(monitor.getScreenResolution());



        return monitorDto;
    }

    public static Monitor monitorDtoToMonitor(MonitorDto monitorDto) {


        Monitor monitor = new Monitor();

        monitor.setId(monitorDto.getId());
        monitor.setManufacturer(monitorDto.getManufacturer());
        monitor.setModel(monitorDto.getModel());
        monitor.setSerialNumber(monitorDto.getSerialNumber());
        monitor.setScreenSize(monitorDto.getScreenSize());
        monitor.setScreenResolution(monitorDto.getScreenResolution());

        return monitor;
    }
}
