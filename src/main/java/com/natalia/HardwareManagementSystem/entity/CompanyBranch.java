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
@Table(name = "company_branch", schema = "hms")
public class CompanyBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "address")
    private String address;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "companyBranch" ,fetch = FetchType.LAZY)
    private Set<User> users;

    @OneToMany(mappedBy = "companyBranch" ,fetch = FetchType.LAZY)
    public Set<Department> departments;
}
