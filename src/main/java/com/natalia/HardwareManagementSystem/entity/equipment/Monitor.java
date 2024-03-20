package com.natalia.HardwareManagementSystem.entity.equipment;

import com.natalia.HardwareManagementSystem.entity.Equipment;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "monitor")
public class Monitor extends Equipment {

    // could be of a predefined list of values
    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "screen_resolution")
    private String screenResolution;
}
