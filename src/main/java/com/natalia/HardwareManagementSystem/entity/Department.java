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
@Table(name = "department", schema = "hms")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @ManyToMany
    @JoinTable(
            name = "department_company_branch",
            joinColumns = @JoinColumn(name = "company_branch_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Set<CompanyBranch> departmentCompanyBranch;
}

