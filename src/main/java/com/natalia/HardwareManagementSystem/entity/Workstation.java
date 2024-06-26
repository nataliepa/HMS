package com.natalia.HardwareManagementSystem.entity;

import javax.persistence.*;

import com.natalia.HardwareManagementSystem.entity.equipment.CompanyPhone;
import com.natalia.HardwareManagementSystem.entity.equipment.Computer;
import com.natalia.HardwareManagementSystem.entity.equipment.Monitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "workstation", schema = "hms")
public class Workstation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_branch_id", referencedColumnName = "id")
    private CompanyBranch companyBranch;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @OneToMany(mappedBy = "workstation" ,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Computer> computers;

    @OneToMany(mappedBy = "workstation" ,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<Monitor> monitors;

    @OneToMany(mappedBy = "workstation" ,fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private Set<CompanyPhone> companyPhones;

    @OneToOne(mappedBy = "workstation" ,fetch = FetchType.LAZY)
    private Employee employee;

    // a 4-digit number that increases according to the last workstation
    @Column(name = "name")
    private String name;
}
