package com.natalia.HardwareManagementSystem.dto.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class EquipmentDto {
    private Integer id;
    private String manufacturer;
    private String model;
    private String serialNumber;
}
