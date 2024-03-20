package com.natalia.HardwareManagementSystem.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comments")
    private String comments;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enable")
    private Integer enable;

    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_branch_id", referencedColumnName = "id")
    private CompanyBranch companyBranch;

    public User(String comments, String lastName, String firstName, String username, String password, Integer enable, Role role, CompanyBranch companyBranch) {
        this.comments = comments;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.role = role;
        this.companyBranch = companyBranch;
    }
}
