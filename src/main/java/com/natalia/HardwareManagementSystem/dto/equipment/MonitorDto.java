package com.natalia.HardwareManagementSystem.dto.equipment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonitorDto extends EquipmentDto {
    private String screenSize;
    private String screenResolution;
}
