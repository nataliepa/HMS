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
}
