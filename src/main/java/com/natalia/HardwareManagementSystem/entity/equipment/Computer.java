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
@Table(name = "computer")
public class Computer extends Equipment {

    @Column(name = "cpu")
    private int cpu;

    @Column(name = "ram")
    private int ram;

    @Column(name = "operating_system")
    private int operatingSystem;
}
