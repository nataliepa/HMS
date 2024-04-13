package com.natalia.HardwareManagementSystem.entity.equipment;

import javax.persistence.*;

import com.natalia.HardwareManagementSystem.entity.Workstation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_phone")
public class CompanyPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "serial_number")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "workstation_id", referencedColumnName = "id")
    private Workstation workstation;

    @Column(name = "phone_number")
    private String phoneNumber;

}
