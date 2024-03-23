package com.natalia.HardwareManagementSystem.entity;

import javax.persistence.*;
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
@Table(name = "employee", schema = "hms")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "workstationId", referencedColumnName = "id")
    private Workstation workstation;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Phone> phones;
}
