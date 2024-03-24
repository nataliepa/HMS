package com.natalia.HardwareManagementSystem.dto.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComputerDto extends EquipmentDto {
    private int cpu;
    private int ram;
    private int operatingSystem;
}
